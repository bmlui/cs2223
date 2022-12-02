import java.util.Arrays;

public class q4 {
    public static void findArkenstonePath(double[][] a ) {
        Gaussian.printMatrix(a);
        double[] maxPath = q4.maxPath(a);
        System.out.println("The starting square is " + maxPath[1]);
        System.out.println("The ending square/number of the vault is " + maxPath[2]);
        System.out.println("The total value/number of gems is " + maxPath[0]);
        System.out.print("The final path is  ");
        for (int i = 3; i < maxPath.length; i++) {
            System.out.print(" -> " + maxPath[i]);
        }
    }

    private static double[] maxPath(double[][] a) {
        int n = a.length;
        double[] returnArr = new double[n+3];
        double[] tempArr = new double[n+3];

        for (int i = 0; i < n; i++) {
            int currentCol = i;
            tempArr[0] = a[0][i];
            tempArr[n] = i+1;
           for (int j = 0; j< n-1; j++) {
               double middleSum = arraySum(tempArr) + a[j + 1][currentCol];
               if (currentCol == 0) { //first row
                   double rightSum = arraySum(tempArr) + a[j + 1][currentCol + 1];
                   if (middleSum > rightSum) {} else {
                       currentCol = currentCol + 1;
                   }
               } else if (currentCol == n - 1) { // last row
                   double leftSum = arraySum(tempArr) + a[j + 1][currentCol - 1];
                   if (middleSum > leftSum) {} else {
                       currentCol = currentCol - 1;
                   }
               } else { // middle row[s]
                   double leftSum = arraySum(tempArr) + a[j + 1][currentCol - 1];
                   double rightSum = arraySum(tempArr) + a[j + 1][currentCol + 1];
                   if (leftSum > rightSum && leftSum > middleSum) {
                       currentCol = currentCol - 1;
                   } else if (rightSum > leftSum && rightSum > middleSum) {
                       currentCol = currentCol + 1;
                   }
               }
               tempArr[j + 1] = a[j + 1][currentCol];
               tempArr[n+1] = currentCol+1;
           }
           tempArr[n+2] = arraySum(tempArr);
           if (arraySum(tempArr) > arraySum(returnArr)) {
               returnArr = tempArr;
           }

           }

        returnArr = reverseArray(returnArr);
        return returnArr;
    }

    private static double arraySum(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length-3; i++) {
            sum += a[i];
        }
        return sum;
    }

    private static double[] reverseArray(double[] a) {
        double[] returnArr = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            returnArr[i] = a[a.length - 1 - i];
        }
        return returnArr;
    }
    public static void printArr(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
