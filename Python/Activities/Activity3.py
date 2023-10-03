strPlayerName1=input("Enter Player1 name: ")
strPlayerName2=input("Enter Player2 name:")

strPlayer1Answer=input(strPlayerName1+" choose anyone from the following rock,papper and scissors:")
strPlayer2Answer=input(strPlayerName2+" choose anyone from the following rock,papper and scissors:")

if strPlayer1Answer.upper()==strPlayer2Answer.upper():
    print ("game is tie")

elif strPlayer1Answer.upper()=="ROCK":
    if strPlayer2Answer.upper()=="SCISSOR":
        print("Rock wins")
    else:
        print("Paper wins")
elif strPlayer1Answer.upper()=="PAPER":
    if strPlayer2Answer.upper()=="ROCK":
        print("Paper wins")
    else:
        print("scissor win")
elif strPlayer1Answer.upper()=="SCISSOR":
    if strPlayer2Answer.upper()=="PAPER":
        print("Scissor wins")
    else:
        print("Rock win")
