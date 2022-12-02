public class Main {
    public static void main(String[] args) {
        //Question 1
        // The ForwardElimination method will not work for the following matrix:
        // x1 + x2 + x3 = 6
        //x1 + x2 + 2x3 = 9
        //x1 + 2x2 + 3x3 = 14
        // The reason is that the method will try to divide by zero, which is not possible.
        // The BetterForwardElimination solves this problem by checking if the pivot is zero.

        //Question 2
        // The BetterForwardElimination method will not work for the following matrix:
        // x1 + x2 + x3 = 6
        //x1 + x2 + 2x3 = 9
        //2x1 + 2x2 + 3x3 = 15


        //Question 3
        double[][] question3matrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 4, -3, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, -2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, -1, 0, 0},
                {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1}};
        double[] q3lastcolumn = {364, 4, 16, 36, 64, 100, 79, 61, 0, 0, 0, -42};
        System.out.println("");
        Gaussian.printMatrix(Gaussian.GaussJordanEliminiation(question3matrix, q3lastcolumn));
        System.out.println("");

        //Question 4
        double[][] question4matrix = {
                {96, 33, 44, 98, 75, 68, 99, 84},
                {10, 41,  1, 86, 46, 24, 53, 93},
                {83, 97, 94, 27, 65, 51, 30,  7},
                {56, 70, 47, 64, 22, 88, 67, 12},
                {91, 11, 77, 48, 13, 71, 92, 15},
                {32, 59, 17, 25, 31,  4, 16, 63},
                {79,  5, 14, 23, 78, 37, 40, 74},
                {35, 89, 52, 66, 82, 20, 95, 21}
        };
        q4.findArkenstonePath(question4matrix);
        
    }


}