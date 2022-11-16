import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Lucas defaultLucas = new Lucas();
        boolean valid = false;
        String run = "";
        do {
            System.out.println("What question would you like to run? Type the integers 1, 2, 3.");
            String kb = scan.nextLine();
            if (kb.equals("1") | kb.equals("2")| kb.equals("3")) {
                valid = true;
                run = kb;
            }
        } while (valid == false);

        if (run.equals("1")) {
            //* Question 1

            System.out.println(defaultLucas.lucas(4));
            //Lucas is known for the Lucas numbers but is also known for posing a challenge to prove the only solution of the Diophantine equation,
            // serving as an artillery office in the French army, and the development of umbral calculus.

        } else if (run.equals("2")){

            //* Question 2
            defaultLucas.testLucas(40);
            for (int i =28; i<40; i++) {
                System.out.println(defaultLucas.lucas(i+1)/defaultLucas.lucas(i) + " val");
                System.out.println(defaultLucas.timeLucas(i+1)/defaultLucas.timeLucas(i) + " time");
            }
            // The ratio is 1.6, also known as the golden ratio .
            // This method has a O(1.6^n) time complexity as it converges to 1.6
            // and grows exponentially both in time and number value.

            Lucas customLucas = new Lucas(2, 5);
            customLucas.testLucas(40);
            for (int i =28; i<40; i++) {
                System.out.println(customLucas.lucas(i+1)/defaultLucas.lucas(i) + " val");
                System.out.println(customLucas.timeLucas(i+1)/defaultLucas.timeLucas(i) + " time");
            }
            // For my custom base case numbers, the ratio is still 1.6 for time O(1.6^n), while the number ratio is 4.5.

        } else {
            //* Question 3
            int numbers[] = {1, 14, 14, 4, 11, 7, 6, 9, 8, 10, 10, 5, 13, 2, 3, 15};
            MagicSquare ms = new MagicSquare();
            System.out.println(ms.find4Combo(numbers, 33)); // bulletpoint 1
            System.out.println(ms.findAllCombo(numbers, 33)); // bulletpoint 2
            System.out.println(ms.findComboRange(numbers)); // bulletpoint 3
            ms.findGreatestCombo(numbers); // bulletpoint 4
        }





    }
}