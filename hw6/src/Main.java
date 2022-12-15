import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //Question 1
        System.out.println(Kween.isLegalPosition(new int[]{1,6,8, 3,7,0,0,0}, 8));
        System.out.println(Kween.isLegalPosition(new int[]{1,6,8, 3,5,0,0,0}, 8));

        //Question 2
        Kween.printBoard(Kween.nextLegalPosition(new int[]{1,6,8, 3,7,0,0,0}, 8));
        Kween.printBoard(Kween.nextLegalPosition(new int[]{1,6,8, 3,7,0,0,0}, 8));
        Kween.printBoard(Kween.nextLegalPosition(new int[]{1,6,8, 3,5,0,0,0}, 8));
        Kween.printBoard(Kween.nextLegalPosition(new int[]{1,6,8, 3,7,4,2,5}, 8));
        Kween.printBoard(Kween.nextLegalPosition(new int[]{2, 4, 1, 3}, 4));

        //Question 3
        Kween.printBoard(Kween.nQueensFirst(4));
        Kween.printBoard(Kween.nQueensFirst(8));
        for (int i = 4; i <= 14; i++) {
            Kween.printBoard(Kween.nQueensFirst(i));
        }

        //Question 4
        LinkedList<int[]> list = Kween.nQueensAll(4);
        for (int i = 0; i < list.size(); i++) {
            Kween.printBoard(list.get(i));
        }
        for (int i = 4; i <= 14; i++) {
            list = Kween.nQueensAll(i);
            System.out.println("There are " + list.size() + " solutions to the " + i + "-queens problem.");
        }




    }



}