public class Gaussian {
    public static void printMatrix(double[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] BetterForwardElimination(double[][] a, double[] b) {
        int n = b.length;
        double[][] augmentedMatrix = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = a[i][j];
            }
            augmentedMatrix[i][n] = b[i];
        }
        int pivotrow;
        for (int i = 0; i < n - 1; i++) {
            pivotrow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(augmentedMatrix[j][i]) > Math.abs(augmentedMatrix[pivotrow][i])) {
                    pivotrow = j;
                }
            }
            for (int k = i; k < n + 1; k++) {
                double temp = augmentedMatrix[pivotrow][k];
                augmentedMatrix[pivotrow][k] = augmentedMatrix[i][k];
                augmentedMatrix[i][k] = temp;
            }
            for (int j = i + 1; j < n; j++) {
                double temp = augmentedMatrix[j][i] / augmentedMatrix[i][i];
                for (int k = i; k < n + 1; k++) {
                    augmentedMatrix[j][k] -= temp * augmentedMatrix[i][k];
                }
            }
        }
        return augmentedMatrix;
    }

    public static double[][] GaussJordanEliminiation(double[][] a, double[] b) {
        int n = b.length;
        double[][] augmentedMatrix = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = a[i][j];
            }
            augmentedMatrix[i][n] = b[i];
        }
        int pivotrow;
        for (int i = 0; i < n; i++) {
            pivotrow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(augmentedMatrix[j][i]) > Math.abs(augmentedMatrix[pivotrow][i])) {
                    pivotrow = j;
                }
            }
            // swap rows
            double[] temparr = augmentedMatrix[i];
            augmentedMatrix[i] = augmentedMatrix[pivotrow];
            augmentedMatrix[pivotrow] = temparr;

            // pivot
            for (int j = 0; j < n; j++) {
                double temp = augmentedMatrix[j][i] / augmentedMatrix[i][i];
                for (int k = 0; k < n; k++) {
                    if (j != i && k != i) {
                        augmentedMatrix[j][k] -= temp * augmentedMatrix[i][k];
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    augmentedMatrix[j][i] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    augmentedMatrix[i][j] /= augmentedMatrix[i][i];
                }
                augmentedMatrix[i][i] = 1;
            }
        }
        return augmentedMatrix;
    }

}
