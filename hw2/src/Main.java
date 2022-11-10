import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        // Question 1
        Lucas defaultLucas = new Lucas();
        System.out.println(defaultLucas.lucas(4));
        //Lucas is known for the Lucas numbers but is also known for posing a challenge to prove the only solution of the Diophantine equation,
        // serving as an artillery office in the French army, and the development of umbral calculus.


        // Question 2
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


        // Question 3





    }
}