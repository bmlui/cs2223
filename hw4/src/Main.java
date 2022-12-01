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
        Gaussian.printMatrix(Gaussian.BetterForwardElimination(new double[][]{{1, 1, 1}, {1, 1, 2}, {1, 2, 3}}, new double[]{6, 9, 14}));
        System.out.println("");
        Gaussian.printMatrix(Gaussian.BetterForwardElimination(new double[][]{{2, -1, 1}, {4, 1, -1}, {1, 1, 1}}, new double[]{1, 5, 0}));
        System.out.println("");

        double[][] one = {
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
        double[] two = {364, 4, 16, 36, 64, 100, 79, 61, 0, 0, 0, -42};
        Gaussian.printMatrix(Gaussian.BetterForwardElimination(one, two));
        System.out.println("");
        Gaussian.printMatrix(Gaussian.GaussJordanEliminiation(one, two));


    }


}