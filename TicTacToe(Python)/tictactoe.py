import random
choice=["X","Y"]
computer=random.choice(choice)
exit=True
if computer=="X":
    Human="Y"
else:
    Human="X"
print("Computer:",computer)
print("Human:",Human)
box=[" "," "," "," "," "," "," "," "," "]
pos=[0,1,2,3,4,5,6,7,8]
turn=random.choice([0,1])
if turn==0:
    print("First Computer turn")
else:
    print("First Human Turn")
def win():
    if box[0]!=" " and box[1]!=" " and box[2]!=" " and box[0]==box[1] and box[1]==box[2] and box[2]==box[0]:
        if computer==box[0]:
            print("WOW! Computer won the Game")
        else:
            print("WOW! Human Won the Game")
        return False
    elif box[3]!=" " and box[4]!=" " and box[5]!=" " and box[3]==box[4] and box[4]==box[5] and box[5]==box[3]:
        if computer==box[3]:
            print("WOW! Computer won the Game")
        else:
            print("WOW! Human Won the Game")
        return False
    elif box[6]!=" " and box[7]!=" " and box[8]!=" " and box[6]==box[7] and box[7]==box[8] and box[8]==box[6]:
        if computer==box[6]:
            print("WOW! Computer won the Game")
        else:
            print("WOW! Human Won the Game")
        return False
    elif box[0]!=" " and box[3]!=" " and box[6]!=" " and box[0]==box[3] and box[3]==box[6] and box[6]==box[0]:
        if computer==box[0]:
            print("WOW! Computer won the Game")
        else:
            print("WOW! Human Won the Game")
        return False
    elif box[1]!=" " and box[4]!=" " and box[7]!=" " and box[1]==box[4] and box[4]==box[7] and box[7]==box[1]:
        if computer==box[1]:
            print("WOW! Computer won the Game")
        else:
            print("WOW! Human Won the Game")
        return False
    elif box[2]!=" " and box[8]!=" " and box[5]!=" " and box[2]==box[5] and box[5]==box[8] and box[8]==box[2]:
        if computer==box[2]:
            print("WOW! Computer won the Game")
        else:
            print("WOW! Human Won the Game")
        return False
    elif box[0]!=" " and box[4]!=" " and box[8]!=" " and box[0]==box[4] and box[4]==box[8] and box[8]==box[0]:
        if computer==box[0]:
            print("WOW! Computer won the Game")
        else:
            print("WOW! Human Won the Game")
        return False
    elif box[2]!=" " and box[4]!=" " and box[6]!=" " and box[2]==box[4] and box[4]==box[6] and box[6]==box[2]:
        if computer==box[2]:
            print("WOW! Computer won the Game")
        else:
            print("WOW! Human Won the Game")
        return False
    elif box[0]!=" " and box[1]!=" " and box[2]!=" " and box[3]!=" " and box[4]!="  " and box[5]!=" " and box[6]!=" " and box[7]!=" " and  box[8]!=" " :
        print("Tie!")
        return False
    else:
        return True
def draw():
    print(box[0]," | ",box[1],"|",box[2])
    print("__ ","  __ ","  __ ",sep="")
    print(box[3]," |",box[4]," |",box[5])
    print("__ ","  __ ","  __ ",sep="")
    print(box[6]," | ",box[7],"|",box[8])
while(exit):
    if turn==0:
        print(f"Computers({computer}) Turn: ",end="".format(computer))
        computer_pos=random.choice(pos)
        print(computer_pos)
        box[computer_pos]=computer
        draw()
        exit=win()
        turn=not(turn)
        pos.remove(computer_pos)
    else:
        print(f"Humans({Human}) Turn: ".format(Human))
        print("Availabale Boxes",pos)
        Human_pos=int(input())
        box[Human_pos]=Human
        draw()
        exit=win()
        turn=not(turn)
        pos.remove(Human_pos)


           
            
            
            
            


