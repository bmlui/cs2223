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
        hw3.printLinkedList(graycodesarefun.BRGC(4));
        String[] names = {"Brandon", "Dylan", "Chris", "Bob", "Alice"};
        graycodesarefun q3 = new graycodesarefun(names);
        System.out.println();
        System.out.println(q3.whoMoves("00011", "00001"));
        System.out.println(q3.whoInPicture("00011"));
        System.out.println(q3.whoInPicture("10001"));

        q3.run();
    }
}