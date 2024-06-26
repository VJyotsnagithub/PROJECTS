import speech_recognition as sr
import pyttsx3
from bs4 import BeautifulSoup
import imaplib
import email
import re
import smtplib
import tkinter
import _thread
import winsound
import configparser
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from PIL import ImageTk, Image

engine = pyttsx3.init()
recognizer = sr.Recognizer()

receive_mail_conn = None
send_mail_conn = None
emailId = ''
OFFSET=5
SEARCH_BATCH_SIZE = 5
gui_pending_tasks = []


def saySomething(phrase):
    print('Engine says...', phrase)
    pushGUITask('SHOW_TEXT', text=phrase)
    engine.say(phrase)
    engine.runAndWait()


def getUserInput(stmt, confirm_input=True, doNotRetry=False, remove_spaces=False, to_lower_case=False):
    with sr.Microphone() as source:
        recognizer.adjust_for_ambient_noise(source, duration=1)
        if (stmt):
            saySomething(stmt)
        print('Listening...')
        pushGUITask('MIC_ENABLED')
        winsound.Beep(440, 150)
        recordedaudio = recognizer.listen(source)
        pushGUITask('MIC_DISABLED')
    try:
        userInput = recognizer.recognize_google(recordedaudio, language='en-US')
        if (remove_spaces):
            userInput = ''.join(userInput.split(' '))
        if (to_lower_case):
            userInput = userInput.lower()
        print('User said...', userInput)
        if (confirm_input):
            saySomething('You said, ' + userInput)
        return userInput
    except Exception as ex:
        print('Error while getting user input...', ex)
        if doNotRetry:
            handleFailure()
        else:
            return getUserInput(stmt, doNotRetry=True)


def sendMail(receipient, mail):
    global send_mail_conn
    global emailId
    print('Sending email...')
    try:
        send_mail_conn.sendmail(emailId, receipient, mail.as_string())
    except Exception as ex:
        print('Error while getting sending mail...', ex)
        handleFailure()
        return


def handleFailure():
    saySomething('Unexpected error occured! Please try again later!')
    exit()


def composeMail():
    global emailId
    # COMPOSE EMAIL
    # -----------------
    # Ask for recipient
    receipient = getUserInput('Please provide the receipient\'s email address.', remove_spaces=True, to_lower_case=True)
    confirmation = getUserInput('Do you want to continue?')
    if(confirmation == 'yes'):
        saySomething('Proceeding to next.')
    else:
        saySomething('Compose mail is cancelled.')
        return
    # Ask for subject
    subject = getUserInput('Please provide the subject of the email.')
    confirmation = getUserInput('Do you want to continue?')
    if(confirmation == 'yes'):
        saySomething('Proceeding to next.')
    else:
        saySomething('Compose mail is cancelled.')
        return
    # Ask for body
    body = getUserInput('Please provide the content of the email.', 10)
    # Get confirmation
    confirmation = getUserInput('Are you sure you want to send the email?')
    if (confirmation == 'yes'):
        # Send Email
        saySomething('Please wait while the mail is being sent.')
        mail = MIMEMultipart('alternative')
        mail['Subject'] = subject
        mail['From'] = emailId
        mail['To'] = receipient
        part1 = MIMEText(body, 'html')
        mail.attach(part1)
        sendMail(receipient, mail)
        saySomething('Your mail has been sent successfully.')
    else:
        saySomething('Your mail has been cancelled.')


def quitApp():
    saySomething('Closing the Application. Thanks for using.')
    quit()


def logout():
    saySomething('You have been logged-out.')


def postLoginMenu():
    options = [
        'Compose mail',
        'Inbox',
        'Logout',
        'Quit'
    ]
    while True:
        choice = readMenuAndGetInput(options)
        if (choice == 'compose mail'):
            composeMail()
        elif (choice == 'inbox'):
            inbox()
        elif (choice == 'log out'):
            logout()
            return
        elif (choice == 'quit'):
            quitApp()
        else:
            saySomething('Could not recognize the option. Please try again.')


def login():
    global emailId
    global send_mail_conn
    global receive_mail_conn
    # emailId = getUserInput('Please provide your email', remove_spaces=True, to_lower_case=True)
    # password = getUserInput('Please provide your password', remove_spaces=True, to_lower_case=True)
    config = configparser.ConfigParser()
    config.read('config.ini')
    emailId = config['user_credentials']['emailId']
    password = config['user_credentials']['password']
    saySomething('Please wait while we login.')
    try:
        SMTP_SERVER = "imap.gmail.com"
        SMTP_PORT = 993
        receive_mail_conn = imaplib.IMAP4_SSL(SMTP_SERVER)
        receive_mail_conn.login(emailId, password)
        send_mail_conn = smtplib.SMTP('smtp.gmail.com', 587) 
        send_mail_conn.ehlo()
        send_mail_conn.starttls()
        send_mail_conn.login(emailId,password)  
        saySomething('Login successful!')
    except Exception as ex:
        saySomething('Unable to login!')
        return
    postLoginMenu()


def parseEmail(data):
    for response_part in data:
        if isinstance(response_part, tuple):
            return email.message_from_bytes(response_part[1])


def getMailDetailsByEmailId(emailId):
    global receive_mail_conn
    receive_mail_conn.select('INBOX')
    category = "Primary"
    status, response = receive_mail_conn.uid('search', 'X-GM-RAW "category:' + category + '"')
    response = response[0].decode('utf-8').split()
    response.reverse()
    mail_checked = 0
    for uid in response:
        mail_checked = mail_checked+1
        status, data = receive_mail_conn.uid('fetch', uid, '(RFC822)')
        mail = parseEmail(data)
        print("Checking mail : " + mail['from'])
        if emailId.lower() in mail['from'].lower():
            confirmation = getUserInput("Found a mail from " + mail["from"] + " received on " + mail.get("date") + ". Do you want me to open it?")
            if confirmation == "yes":
                return mail
            else:
                saySomething("Okay continuing the search.")
        if mail_checked % SEARCH_BATCH_SIZE == 0:
            helper_text = "first"
            if mail_checked > SEARCH_BATCH_SIZE:
                helper_text = "next"
            choice = getUserInput("Couldn't find the mail from " + helper_text + " " + str(SEARCH_BATCH_SIZE) + " mails in the inbox, should I continue the search?")
            if choice == "no":
                saySomething("Stopping the search.")
                return "canceled"
            else:
                saySomething("Continuing the search.")
    return None
    

def getMails(skip=0, limit=OFFSET):
    global receive_mail_conn
    receive_mail_conn.select('INBOX')
    category = "Primary"
    status, response = receive_mail_conn.uid('search', 'X-GM-RAW "category:' + category + '"')
    response = response[0].decode('utf-8').split()
    response.reverse()
    response = response[skip:min(skip+limit, len(response))]
    mails = []
    for uid in response:
        status, data = receive_mail_conn.uid('fetch', uid, '(RFC822)')
        mail = parseEmail(data)
        mails.append(mail)
    return mails


def readMails(mails):
    saySomething("Received mails from the following...")
    for mail in mails:
        saySomething(mail["from"])


def extractContentFromHTML(html):
    soup = BeautifulSoup(html, 'html.parser')
    text = soup.get_text(strip = True)
    text = re.sub('\s+', ' ', text)
    return text


def readMailDetails(mail):
    try:
        saySomething('Here are the details of the mail from ' + mail['from'])
        content_type = mail.get_content_type()
        if (content_type == 'text/html'):
            payload = mail.get_payload(decode = True)
            content = extractContentFromHTML(payload)
            saySomething('Warning! This content was extracted from HTML so it could be in-accurate.')
            saySomething(content)
        elif (content_type == 'multipart/alternative'):
            payload = mail.get_payload(decode = False)
            content = payload[0].get_payload()
            content = re.sub('\s+', ' ', content)
            saySomething(content)
        else:
            print('ERROR! Unhandled content_type', content_type)
            saySomething('Could not fetch the email.')
    except Exception as ex:
        saySomething('Unable to read the mail. Please try again later.')


def inbox():
    options = [
        'Read Mail',
        'Search Mail',
        'Go Back',
    ]
    while True:
        choice = readMenuAndGetInput(options)
        if (choice == 'read mail'):
            readMailFromInbox()
        elif (choice == 'search mail'):
            from_address = getUserInput('Please provide a from address.')
            saySomething('Please wait while we search for the mail.')
            mail_to_be_opened = getMailDetailsByEmailId(from_address)
            if mail_to_be_opened != "canceled":
                if mail_to_be_opened:
                    readMailDetails(mail_to_be_opened)
                else:
                    saySomething('Could not find email.')
        elif (choice == 'go back'):
            break
        elif (choice == 'quit'):
            quitApp()
        else:
            saySomething('Could not recognize the option. Please try again.')


def readMailFromInbox():
    saySomething("Please wait while we load your mails from the inbox.")
    skip = 0
    mails = getMails(skip)
    saySomething("Here are the latest " + str(OFFSET) + " mails from your inbox.")
    readMails(mails)
    options = [
        'Read More',
        'Open Mail',
        'Go Back'
    ]
    while True:
        choice = readMenuAndGetInput(options)
        if choice == "read more":
            saySomething("Please wait!")
            skip = skip + OFFSET
            mails = getMails(skip)
            readMails(mails)
        elif choice == "open mail":
            saySomething("Please go back and navigate to search mail to open the mail.")
        elif (choice == 'go back'):
            break
        elif (choice == 'quit'):
            quitApp()
        else:
            saySomething('Could not recognize the option. Please try again.')


def register():
    firstname = getUserInput("Please provide your first name.")
    lastname = getUserInput("Please provide your last name.")
    email_address = getUserInput("Please provide your email address.")
    confirmation = getUserInput("Are you sure you want to submit the registration request?")
    if confirmation == "yes":
        # TODO : sending the request to admin
        saySomething("Thank you for registering! Your request has been forwarded to our admin. We will reach out to you shortly.")
    else:
        saySomething("Your registration request has been canceled.")


def mainMenu():
    saySomething('Welcome to Audio Email Service.')
    options = [
        'Register',
        'Login',
        'Quit'
    ]
    while True:
        choice = readMenuAndGetInput(options)
        if (choice == 'login'):
            login()
        elif (choice == 'register'):
            register()
        elif (choice == 'quit'):
            quitApp()
        else:
            saySomething('Could not recognize the option. Please try again.')


def readMenuAndGetInput(options):
    saySomething('Here are your available options.')
    for option in options:
        saySomething(option)
    choice = getUserInput('Please choose an option.')
    return choice


def pushGUITask(task_name, **kwargs):
    gui_pending_tasks.append((task_name, kwargs))


def initGUI():
    gui = tkinter.Tk()
    guiDimensions = {
        'width': 400,
        'height': 550,
        'canvas_width': 400,
        'canvas_height': 300
    }
    gui.title('Voice Based Email')
    gui.resizable(False, False)
    gui.geometry('%dx%d+%d+%d' % (guiDimensions['width'], guiDimensions['height'], (gui.winfo_screenwidth() / 2) - (guiDimensions['width'] / 2), (gui.winfo_screenheight() / 2) - (guiDimensions['height'] / 2)))
    mailIcon = tkinter.PhotoImage(file='assets/emailIcon.png')
    gui.iconphoto(False, mailIcon)
    canvas = tkinter.Canvas(gui, width=guiDimensions['canvas_width'], height=guiDimensions['canvas_height'])
    canvas.pack()
    micEnabledIcon = Image.open('assets/micEnabledIcon.png')
    mic_image_off = 10
    mic_image_len = min(guiDimensions['canvas_width'], guiDimensions['canvas_height']) - mic_image_off
    micEnabledIcon = micEnabledIcon.resize((mic_image_len, mic_image_len))
    micEnabledIcon = ImageTk.PhotoImage(micEnabledIcon)
    micDisabledIcon = Image.open('assets/micDisabledIcon.png')
    micDisabledIcon = micDisabledIcon.resize((mic_image_len, mic_image_len))
    micDisabledIcon = ImageTk.PhotoImage(micDisabledIcon)
    micIconInCanvas = canvas.create_image(guiDimensions['canvas_width'] / 2, guiDimensions['canvas_height'] / 2, anchor=tkinter.CENTER, image=micDisabledIcon)
    textBot = tkinter.Label(gui, text='Voice Based Email', wraplength=300, justify="center")
    textBot.pack()

    def calcLinesOccupied(lines):
        lines_occupied = 0
        curr_line_len = 0
        for line in lines:
            words = line.split(' ')
            for word in words:
                curr_line_len += len(word) + 1
                if curr_line_len > 52:
                    lines_occupied += 1
                    curr_line_len = 0
            if curr_line_len > 0:
                lines_occupied += 1
        lines_occupied += len(lines) - 1
        return lines_occupied

    def timertick():
        while len(gui_pending_tasks) > 0:
            (task_name, kwargs) = gui_pending_tasks.pop(0)
            if task_name == 'MIC_ENABLED':
                canvas.itemconfig(micIconInCanvas, image=micEnabledIcon)
            if task_name == 'MIC_DISABLED':
                canvas.itemconfig(micIconInCanvas, image=micDisabledIcon)
            if task_name == 'SHOW_TEXT':
                lines = textBot['text'].split('\n\n')
                lines.append(kwargs['text'])
                textBot['text'] = '\n\n'.join(lines)
                lines_occupied = calcLinesOccupied(lines)
                while lines_occupied > 17:
                    if (len(lines[0]) > 52):
                        lines[0] = lines[0][52:]
                    else:
                        lines.pop(0)
                    lines_occupied = calcLinesOccupied(lines)
                textBot['text'] = '\n\n'.join(lines)

        gui.after(100, timertick)

    def on_closing():
        pass

    timertick()
    gui.protocol('WM_DELETE_WINDOW', on_closing)
    gui.mainloop()

if __name__ == '_main_':
    _thread.start_new_thread(initGUI, ())
mainMenu()