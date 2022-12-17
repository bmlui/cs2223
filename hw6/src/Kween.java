import java.util.LinkedList;

/**
 * This class contains methods that solve the n-queens problem.
 */
public class Kween {

    /**
     * Determines if the given position is legal.
     * @param boardOrig The board to check.
     * @param n The number of queens on the board.
     * @return True if the board is legal, false otherwise.
     */
    public static boolean isLegalPosition(int[] boardOrig, int n) {
        int[] board = new int[n];
        // augment the board with index position
        for (int i = 0; i < n; i++) {
            if (boardOrig[i] > n) {
                return false;
            }
            if (boardOrig[i] == 0) {
                board[i] = -1;
            } else {
                board[i] = boardOrig[i] - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (board[j] != -1) {
                    if (board[i] == board[j] || Math.abs(board[i] - board[j]) == j - i) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Determines if the given position is legal.
     * @param boardOrig The board to check.
     * @param n The number of queens on the board.
     * @param rowIndex The row index to check.
     * @return True if the board is legal, false otherwise.
     */
    public static boolean isLegalPosition(int[] boardOrig, int n, int rowIndex) {
        int row = rowIndex + 1;
        int[] board = new int[row];
        // augment the board with index position
        if (boardOrig[rowIndex] > n) {
            return false;
        }
        for (int i = 0; i < row; i++) {
            if (boardOrig[i] == 0) {
                board[i] = -1;
            } else {
                board[i] = boardOrig[i] - 1;
            }
        }
        for (int i = 0; i < rowIndex; i++) {
            if (board[rowIndex] != -1) {
                if (board[i] == board[rowIndex] || Math.abs(board[i] - board[rowIndex]) == rowIndex - i) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines if the given board is full
     * @param boardOrig The board to check.
     * @param n The number of queens on the board.
     * @return True if the board is full, false otherwise.
     */
    private static boolean boardFull(int[] boardOrig, int n) {
        for (int i = 0; i < n; i++) {
            if (boardOrig[i] == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines the next legal position for the given board.
     * @param boardOrig The board to check.
     * @param n The number of queens on the board.
     * @return The board of with the next legal position.
     */
    public static int[] nextLegalPosition(int[] boardOrig, int n) {
        // checks if board is full and legal
        if (isLegalPosition(boardOrig, n, n-1) && boardFull(boardOrig, n)) {
            if (boardOrig[n - 1] == n) {
                boardOrig[n - 1] = 0;
                boardOrig[n - 2]++;
            } else {
                boardOrig[n - 1]++;
            }
        }

        int[] returnBoard = new int[n]; //initalizes returnboard
        for (int i = 0; i < n; i++) {
            boolean isLegal = isLegalPosition(boardOrig, n, i);
            if (boardOrig[i] > 0 && isLegal) {
                returnBoard[i] = boardOrig[i];  // sets returnboard to boardOrig if legal
            } else {
                if (boardOrig[0] > n) {  // if backtracking gets to last line of first row, we know it's the end
                    for (int j = 0; j < n; j++) {
                        returnBoard[j] = 0;  // sets returnboard to 0
                    }
                    return returnBoard; // returns 0 board
                }
                if (boardOrig[i] >= n) { // if the current row is full, backtrack
                    returnBoard[i] = 0;
                    returnBoard[i - 1]++;
                    return Kween.nextLegalPosition(returnBoard, n);
                } else {  // if the current row is not full, increment
                    returnBoard[i] = boardOrig[i] + 1;
                }
                for (int j = returnBoard[i]; j <= n; j++) {
                    returnBoard[i] = j;
                    if (isLegalPosition(returnBoard, n, i)) {
                        return returnBoard;
                    }
                }
                returnBoard[i] = 0; // if no legal position is found in current row, backtrack
                returnBoard[i - 1]++;
                return Kween.nextLegalPosition(returnBoard, n);
            }

        }
        return returnBoard;
    }

    /**
     * Determines the first solution to the n-queens problem.
     * @param n The number of queens on the board/ size of the baord.
     * @return The first solution to the n-queens problem.
     */
    public static int[] nQueensFirst(int n) {
        int[] board = new int[n];
        board[0] = 1;
        while (board[n - 1] == 0) {
            board = Kween.nextLegalPosition(board, n);
        }
        return board;
    }

    /**
     * Sums all numbers in the given int[] array
     * @param array The array to sum.
     * @return The sum of all numbers in the array.
     */
    public static int arraySum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Determines all the solutions to the n-queens problem.
     * @param n The number of queens on the board/ size of the baord.
     * @return A linkedlist of arrays of all solutions to the n-queens problem.
     */
    public static LinkedList<int[]> nQueensAll(int n) {
        int[] board;
        board = nQueensFirst(n);
        LinkedList<int[]> returnList = new LinkedList<int[]>();
        returnList.add(board);

        while (arraySum(board) != 0) {
            board = Kween.nextLegalPosition(board, n);
                if (boardFull(board, n)) {
                    int[] emptyBoard = new int[n];
                    for(int i = 0; i < n; i++) {
                        emptyBoard[i] = board[i];
                    }
                    returnList.add(emptyBoard);
                }
        }
        return returnList;
    }

    /**
     * Prints the given chess board.
     * @param boardOrig The board to print.
     */
    public static void printBoard(int[] boardOrig) {
        Kween.printArray(boardOrig);

        int n = boardOrig.length;
        int[] board = new int[n];
        // augment the board with index position
        for (int i = 0; i < n; i++) {
            if (boardOrig[i] == 0) {
                board[i] = -1;
            } else {
                board[i] = boardOrig[i] - 1;
            }
        }
        //print out the column numbers
        System.out.print("   ");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                //print out the row numbers
                if (j == 0) {
                    System.out.print(i + 1 + "  ");
                }
                //print out the board with the queens
                if (board[i] == j) {
                    System.out.print("X  ");
                } else {
                    System.out.print(".  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Prints the given array.
     * @param array The array to print.
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
