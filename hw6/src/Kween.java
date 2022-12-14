public class Kween {

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

    public static boolean isLegalPosition(int[] boardOrig, int n, int rowIndex) {
        int row = rowIndex + 1;
        int[] board = new int[row];
        // augment the board with index position
        if (boardOrig[rowIndex] > n) {
            return false;
        }
        for (int i = 0; i <row; i++) {
            if (boardOrig[i] == 0) {
                board[i] = -1;
            } else {
                board[i] = boardOrig[i] - 1;
            }
        }
        for (int i = 0; i <rowIndex; i++) {
                if (board[rowIndex] != -1) {
                    if (board[i] == board[rowIndex] || Math.abs(board[i] - board[rowIndex]) == rowIndex - i) {
                        return false;
                    }
            }
        }
        return true;
    }

    public static int[] nextLegalPosition(int[] boardOrig, int n) {
        int[] returnBoard = new int[n];
        for (int i = 0; i < n; i++) {
            if (boardOrig[i] > 0) {
                returnBoard[i] = boardOrig[i];
            } else {
                for (int j = 1; j <= n; j++) {
                    returnBoard[i] = j;
                    if (isLegalPosition(returnBoard, n, i)) {
                        return returnBoard;
                    }
                }
            }

        }
        return returnBoard;
    }

    public static int[] nQueensFirst(int n) {
        int[] board = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i] = j;
                if (isLegalPosition(board, n, i)) {
                    break;
                }
            }
        }
        return board;
    }

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

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
