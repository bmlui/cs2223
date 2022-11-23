import org.omg.CORBA.INTERNAL;

import java.util.*;

public class hw3 {
    public hw3() {
    }

    /**
     * @param input
     * @return
     */
    public static boolean palindromecheck(String input) {
        String nInput = input.toLowerCase(Locale.ROOT);
        nInput = nInput.replaceAll(" ", "");
        System.out.println(nInput);
        return check(nInput);
    }

    /**
     * @param input
     * @return
     */
    public static boolean check(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        } else {
            int n = input.length();
            if (input.charAt(0) == (input.charAt(n - 1))) {
                return check(input.substring(1, n - 1));
            }
        }
        return false;
    }

    /**
     * @param input
     * @return
     */
    public static int easyinversioncount(int[] input) {
        int counter = 0;
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    int count = 0;
    public int fastinversioncount(int[] input) {
         count = 0;
        this.mergeSort(input);
        return count;
    }
    public int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);

        return merge(arr1, arr2);
    }
    public int[] merge(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int[] countArr = new int[arr1Length+arr2Length];
        int i =0; int j = 0; int k = 0;
        while((i < arr1Length) && (j < arr2Length)) {
            if (arr1[i] > arr2[j]) {
                countArr[k] = arr2[j];
                k++;
                j++;
                count += arr1Length - i;
            } else {
                countArr[k] = arr1[i];
                k++;
                i++;
            }
        }
        while (i<arr1Length) {
            countArr[k] = arr1[i];
            k++;
            i++;
        }
        while (j<arr2Length) {
            countArr[k] = arr2[j];
            k++;
            j++;
        }
        return countArr;


    }
   public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void printLinkedList(LinkedList<String> arr) {
        for(String s: arr) {
            System.out.print(s +' ');
        }
    }






}
