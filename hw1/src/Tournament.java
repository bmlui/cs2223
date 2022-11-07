public class Tournament {

    int playerScore = 0;
    int compScore = 0;
        public Tournament() {}
    public void startTournament () {
        DoubleTrouble DT = new DoubleTrouble();
            boolean done = false;
        System.out.println("________________________________________________");
        System.out.println("The current score is:");
        System.out.println("Player: " + playerScore);
        System.out.println("Computer: " + compScore);
        System.out.println("________________________________________________");
        System.out.println("Welcome to DoubleTrouble. Enter 0 to free play or 1 to play a tournament (set of 3 games). ");
        int gameStyle =  DT.askUser(0,1,"Enter 0 to free play or 1 to play a tournament");
        if (gameStyle == 0) {
            System.out.println("Starting free play.");
        }
      else if (gameStyle == 1) {
            System.out.println("Starting a tournament of 3 games. The winner will be chosen after these games. ");
        }
        int gameNum =0;
            do {
                gameNum++;
                System.out.println("Starting Game " + gameNum);
                int winner = DT.screen();
                if (winner == 1) {
                    playerScore++;
                } else if (winner==2) {
                    compScore++;
                }
                System.out.println("________________________________________________");
                System.out.println("Score status. The current score is:");
                System.out.println("Player: " + playerScore);
                System.out.println("Computer: " + compScore);
                System.out.println("________________________________________________");
                if (gameStyle ==1 && gameNum >=3) {
                  done= true;
                } else if (gameStyle ==0) {
                    System.out.println("Good game! Enter 1 to play again and 2 to quit.");
                    int playAgain=  DT.askUser(1,2,"Enter 1 to play again and 2 to quit.");
                    if (playAgain == 2) {
                        done = true;
                    }
                }

            } while(done == false);

        System.out.println("________________________________________________");
        System.out.println("Thank you for playing. The final score is");
        System.out.println("Player: " + playerScore);
        System.out.println("Computer: " + compScore);
        if (playerScore>compScore)  System.out.println("Congratulations you have won.");
        if (compScore>playerScore)  System.out.println("The computer has won.");
        if (compScore==playerScore)  System.out.println("Tie!");
        System.out.println("________________________________________________");
    }

}
