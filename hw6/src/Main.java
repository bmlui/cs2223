public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //Question 1
        System.out.println(Kween.isLegalPosition(new int[]{1,6,8, 3,7,0,0,0}, 8));
        System.out.println(Kween.isLegalPosition(new int[]{1,6,8, 3,5,0,0,0}, 8));

        //Question 2
        Kween.printBoard(Kween.nextLegalPosition(new int[]{1,6,8, 3,7,0,0,0}, 8));

        //Question 3
        Kween.printBoard(Kween.nQueensFirst(4));

        //
    }



}