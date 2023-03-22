import jdk.nashorn.internal.runtime.ECMAException;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
public class DoubleTrouble {

    private Stones green = new Stones(3, "Green");
    private Stones yellow = new Stones(7, "Yellow");
    private Stones orange =  new Stones(5, "Orange");
    private int winner = -999;

    private Scanner keyboard = new Scanner(System.in);

    /**
     * Asks if player wants to go first or second, returns if the player wants to go first or second
     */
    public int askUser(int lowest, int highest, String error) {
        int valid = 0;
        int userValue = -999;
        do {
            try {
                userValue = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Input must be an integer.");
            }
            if ((userValue >= lowest) && (userValue <= highest)) {
                valid = 1;
            } else {
                System.out.println("Error: Invalid input. " + error);
            }
            keyboard.nextLine();
        } while (valid == 0);
        return userValue;
    }
    /**
     * Prints out the current game board, number of stones in each pile
     */
    public void printBoard() {
        System.out.println("1: green count: " + green.getNumStones());
        System.out.println("2: yellow count: " + yellow.getNumStones());
        System.out.println("3: orange count: " + orange.getNumStones());
    }
    /**
     * Takes in an int and returns a stones object
     */
    private Stones numKeyToStones(int i) {
        if (i == 1) {
            return this.green;
        } else if (i == 2) {
            return this.yellow;
        } else {
            return this.orange;
        }
    }
    /**
     * Asks player questions to see what they would like for their turn
     */
private void playerTurnAsk() throws ColorOutException, BackException{
    System.out.println("Choose a color. Choose 1 for green 2 for yellow and 3 for orange.");
    int userRowColor = this.askUser(1, 3, "Choose 1 for green 2 for yellow and 3 for organge.");
    if (numKeyToStones(userRowColor).getNumStones() == 0) {
        throw new ColorOutException(numKeyToStones(userRowColor).getName());
    }
    System.out.println("You have chosen: " + this.numKeyToStones(userRowColor).getName() +". How many of these stones would you like to take away? You can take away a maximum of: "
            + this.numKeyToStones(userRowColor).getNumStones() + " stones. Enter 0 to go back.");
    int userNumOfStones = this.askUser(0, this.numKeyToStones(userRowColor).getNumStones(), "You can take a minimum of 1 and maximum of "
            + this.numKeyToStones(userRowColor).getNumStones() +
            " " + this.numKeyToStones(userRowColor).getName() + " stones. Please try again.");
    if (userNumOfStones == 0) {
        throw new BackException();
    }
    try {
        this.numKeyToStones(userRowColor).subNumStones(userNumOfStones);
    }
    catch (InvalidInputException e) {
        throw new BackException();
    }
    System.out.println("You have taken " + userNumOfStones +  " stones from the " + this.numKeyToStones(userRowColor).getName() + " pile. It is nowd the computer's turn.");

}

    /**
     * Calls printBoard() for the player's turn and calls playerTurnAsk(). Takes in nothing, returns true if the game is completed
     */
    private boolean playerTurn() {
        int valid = 0;
           do {
               try {
                   this.printBoard();
                   this.playerTurnAsk();
                   valid = 1;
               } catch (ColorOutException e) {
                   System.out.println("Error: You cannot choose " + e.getColor() + " as there are no more stones in that pile. Please try again. ");
               } catch (BackException e) {
               }
           } while (valid ==0);
        if ((green.getNumStones() + yellow.getNumStones() + orange.getNumStones()) == 0) {
            this.winner = 1;
            return true;
        } else {
        return false;
        }
    }
    /**
     * Subtracts one randomly from the Stones
     */
    private void randomSubOne(LinkedList<Stones> LLStones) {
        if (LLStones.isEmpty()) {
            throw new RuntimeException();
        } else {
            try {
                LLStones.getFirst().subNumStones(1);
                System.out.println("Computer has taken 1 stone from the " + LLStones.getFirst().getName() + " pile.");
            } catch (InvalidInputException e) {
                LLStones.removeFirst();
                randomSubOne(LLStones);
            }
        }
    }
    /**
     * Plays a calculated move
     */
    private void calculatedSub(LinkedList<Stones> LLStones, int counter) {
        if (counter >= 3) {
            throw new RuntimeException();
        } counter++;
        if (LLStones.get(0).getNumStones() > (LLStones.get(1).getNumStones() ^ LLStones.get(2).getNumStones())) {
           int i = 1;
           boolean done = false;
            do {
                if (i>(LLStones.get(0).getNumStones())) {
                    LLStones.add(LLStones.getFirst());
                    LLStones.removeFirst();
                    calculatedSub(LLStones, counter);
                    done = true;
                } else if (((LLStones.get(0).getNumStones()-i) ^ LLStones.get(1).getNumStones() ^ LLStones.get(2).getNumStones()) == 0) {
                    done = true;
                    try {
                        LLStones.get(0).subNumStones(i);
                        System.out.println("Computer has taken " +  i + " stone(s) from the " + LLStones.getFirst().getName() + " pile.");
                    } catch (InvalidInputException e) {
                        throw new RuntimeException();
                    }
                } else {
                    i++;
                    done = false;
                }

            } while (done == false);

        } else {
            LLStones.add(LLStones.getFirst());
            LLStones.removeFirst();
            calculatedSub(LLStones, counter);
        }
    }
    /**
     * Starts the computer turn of the game. starts a random or strategized play depending on if there is a winning move available
     */
    private boolean computerTurn() {
         LinkedList<Stones> LLStones = new LinkedList<Stones>();
        LLStones.add(green);
        LLStones.add(yellow);
        LLStones.add(orange);
        Collections.shuffle(LLStones);
        if ((green.getNumStones() ^ yellow.getNumStones() ^ orange.getNumStones()) == 0) {
                this.randomSubOne(LLStones);
       } else {
          this.calculatedSub(LLStones, 0);
            //this.randomSubOne(LLStones);
       }
        System.out.println("Computer turn is over. Now your turn.");
        if ((green.getNumStones() + yellow.getNumStones() + orange.getNumStones()) == 0) {
            this.winner = 2;
            return true;
        } else {
            return false;
        }
        }

    /**
     * Starts the game and takes in whether the computer or user is going first
     */
public void startGame(int firstPlay) {
    boolean gameDone = false;
    if (firstPlay == 1) {
        do {
        gameDone = this.playerTurn();
           // gameDone = this.computerTurn();
        if (gameDone) break;
       gameDone = this.computerTurn();
          //  gameDone = this.playerTurn();
        }while(gameDone==false);
    } else {
        this.printBoard();
       do  {
            gameDone = this.computerTurn();
            if (gameDone) break;
            gameDone = this.playerTurn();
        }while(gameDone==false);
    }

}
    /**
     * Resets state of the game to original
     */
    private void resetGame() {
        this.green = new Stones(3, "Green");
        this.yellow = new Stones(7, "Yellow");
         this.orange =  new Stones(5, "Orange");
         this.winner = -999;
    }
    /**
     * The state of the game, starts the game
     */
    public int screen() {
        System.out.println("Welcome! " +
                "Would you like to go first or second? Type \"1\" to go first and \"2\" to go second.");
        int firstPlay = this.askUser(1, 2, "Please type \"1\" to go first and \"2\" to go second.");
        this.startGame(firstPlay);
        this.printBoard();
        if (this.winner == 1) {
            System.out.println("Game over. Congrats you have won!");
            this.resetGame();
            return 1;
        } else if (this.winner ==2){
            System.out.println("Game over. Computer has won.");
            this.resetGame();
            return 2;
        } else {
            throw new RuntimeException();
        }
    }

}
