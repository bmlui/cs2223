public class Lucas {
    public Lucas() {}

    /**
     * Function to calculate the nth lucas number
     * @param n integer which n>1, nth lucas number
     * @return the value of L(n) = L(n −1) + L(n −2) for n > 1 where L(0) = 2 and L(1) = 1
     */
    public int lucas(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 1;
        } else {
            return lucas(n - 1) + lucas(n - 2);
        }
    }

    /**
     * Tests the this.lucas(int n) function and prints out value and time taken for every number up to n
     * @param n n integer which n>1, prints out all lucas numbers up to n
     */
    public void testLucas(int n) {
        if (n <= 1) {
        } else {
            long startTime = System.currentTimeMillis();
            int val = this.lucas(n);
            long endTime = System.currentTimeMillis();
            System.out.println(n + "th value = " + val + ". Time taken: " + (endTime - startTime) + " ms");
            this.testLucas(n - 1);
        }
    }

    /**
     * Computes the sequence of numbers and returns an int
     * @param n n integer which n>1
     * @param n0 initial value of L(0)
     * @param n1 initial value of L(1)
     * @return the value of L(n) = L(n −1) + L(n −2) for n > 1 where L(0) = n0 and L(1) = n1
     */
    public int customLucas(int n, int n0, int n1) {
        if (n == 0) {
            return n0;
        } else if (n == 1) {
            return n1;
        } else {
            return customLucas(n - 1, n0, n1) + customLucas(n - 2, n0, n1);
        }
    }
    /**
     * Tests the this.customLucas(int n, int n0, int n1) function and prints out value and time taken for every number up to n
     * @param n n integer which n>1
     * @param n0 initial value of L(0)
     * @param n1 initial value of L(1)
     */
    public void testCustomLucas(int n, int n0, int n1) {
        if (n <= 1) {
        } else {
            long startTime = System.currentTimeMillis();
            int val = this.customLucas(n, n0, n1);
            long endTime = System.currentTimeMillis();
            System.out.println(n + "th value = " + val + ". Time taken: " + (endTime - startTime) + " ms");
            this.testCustomLucas(n-1, n0, n1);
        }
    }
}
