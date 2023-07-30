import random
choice=["Rock","Paper","Scissor"]
computer_score=0
Human_score=0
while True:
    human=input("Rock, Paper or Scissor? To End the Game Enter END: ")
    computer=random.choice(choice)
    if computer==human:
        print("Tie!")
    elif human=="Rock":
        if computer=="Paper":
            print("You Lose the Game",computer,"covers",human)
            computer_score+=1
        elif computer=="Scissor":
            print("You Won the Game",human,"smashes",computer)
            Human_score+=1
    elif human=="Paper":
        if computer=="Rock":
            print("You Won the Game",human,"covers",computer)
            Human_score+=1
        elif computer=="Scissor":
            print("You Lose the Game",computer,"cuts",human)
            Computer_score+=1
    elif human=="Scissor":
        if computer=="Rock":
            print("You Lose the Game",computer,"smashes",human)
            computer_score+=1
        elif computer=="Paper":
            print("You Won the Game",human,"cuts",computer)
            Human_score+=1
    elif human=="END":
        print("Final Scores")
        print('Human Score',Human_score)
        print("Computer Score",computer_score)
        break