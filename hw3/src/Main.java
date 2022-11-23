import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // question 1 
        Scanner scan = new Scanner(System.in);
        System.out.println("Type in a string below and the computer will check if it is a palindrome.");
        String input = scan.nextLine();
        System.out.println(hw3.palindromecheck(input));

        //question 2
        int[] array = {3, 2, 1, 6, 2, 4};
        System.out.println(hw3.easyinversioncount(array));
        hw3 hw3 = new hw3();
        System.out.println( hw3.fastinversioncount(array));

        // question 3
        hw3.printLinkedList(hw3.BRGC(3));

    }
}