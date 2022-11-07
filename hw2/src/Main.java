import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        Lucas l = new Lucas();
        System.out.println(l.lucas(4));
        l.testLucas(40);
        l.testCustomLucas(40, 2, 12);
    }
}