import java.util.Arrays;
import java.util.LinkedList;

import static java.util.Collections.copy;
import static java.util.Collections.max;

public class q4 {


    public static void findArkenstonePath(double[][] a1) {
        double[][] orig = new double[a1.length][a1.length];
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1.length; j++) {
                orig[i][j] = a1[i][j];
            }
        }
        Gaussian.printMatrix(a1);
        double[][] maxArr = q4.maxArr(a1);
        LinkedList<Double> path = q4.getPath(maxArr, orig);
        System.out.println("a) The starting square is " + path.get(path.size()-1));
        System.out.print("b) The final path is  ");
        for (int i = path.size()-2; i >1; i--) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
        System.out.println("c) The total value/number of gems is " + path.get(0));
        System.out.println("d) The ending square/number of the vault is " + path.get(1));
        Gaussian.printMatrix(a1);
    }

    public static double[][] maxArr(double[][] A) {
        int n = A.length;
        double[][] a = reverseArray(A);
        double total = -1;

        for (int i = 1; i < n; i++) {
            total = -1;
            for (int j = 0; j < n ; j++) {
                double middleSum = a[i][j] + a[i - 1][j];
                if (j == 0) { //first row
                    double rightSum = a[i][j] + a[i - 1][j + 1];
                    if (middleSum > rightSum) {
                        a[i][j] = middleSum;
                    } else {
                        a[i][j] = rightSum;
                    }
                } else if (j == n - 1) { // last row
                    double leftSum = a[i][j] + a[i - 1][j - 1];
                    if (middleSum > leftSum) {
                        a[i][j] = middleSum;
                    } else {
                        a[i][j] = leftSum;
                    }
                } else { // middle row[s]
                    double leftSum = a[i][j] + a[i - 1][j - 1];
                    double rightSum = a[i][j] + a[i - 1][j + 1];
                    if (leftSum > rightSum && leftSum > middleSum) {
                        a[i][j] = leftSum;
                    } else if (rightSum > leftSum && rightSum > middleSum) {
                        a[i][j] = rightSum;
                    } else {
                        a[i][j] = middleSum;
                    }
                }
                total = Math.max(a[i][j], total);
            }
        }
        return a;
    }

    public static LinkedList<Double> getPath(double[][] A, double[][] original) {
        double[][] a = reverseArray(A);
        int n = A.length;
        LinkedList<Double> path = new LinkedList<>();
        int column = 0;
        // beginning column
        for (int i = 0; i < n; i++) {
            if (a[0][i] > a[0][column]) {
                column = i;
                path.add(a[0][i]);
                path.add((double) i+1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                path.add(original[i][column]);
                path.add((double) column+1);
            } else {
                if (column == 0) {
                    if (a[i][column] - a[i + 1][column + 1] == original[i][column]) {
                        path.add(original[i][column]);
                        column++;
                    } else {
                        path.add(original[i][column]);
                    }
                } else if (column == n - 1) {
                    if (a[i][column] - a[i + 1][column - 1] == original[i][column]) {
                        path.add(original[i][column]);
                        column--;
                    } else {
                        path.add(original[i][column]);
                    }
                } else {
                    if (a[i][column] - a[i + 1][column - 1] == original[i][column]) {
                        path.add(original[i][column]);
                        column--;
                    } else if (a[i][column] - a[i + 1][column + 1] == original[i][column]) {
                        path.add(original[i][column]);
                        column++;
                    } else {
                        path.add(original[i][column]);
                    }
                }
            }
        }
        return path;
    }


    public static double[][] reverseArray(double[][] a) {
        double[][] returnArr = new double[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            returnArr[i] = a[a.length - 1 - i];
        }
        return returnArr;
    }

    public static void printLinkedList(LinkedList<Double> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

}
