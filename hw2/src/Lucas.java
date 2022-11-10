public class Lucas {
    private int n0 = 2;
    private int n1 = 1;
    public Lucas() {}
    public Lucas(int n0, int n1) {
        this.n0 = n0;
        this.n1 = n1;
    }

    /**
     * Function to calculate the nth lucas number
     * @param n integer which n>1, nth lucas number
     * @return the value of L(n) = L(n −1) + L(n −2) for n > 1 where L(0) = n0 and L(1) = n1
     */
    public double lucas(int n) {
        if (n == 0) {
            return n0;
        } else if (n == 1) {
            return n1;
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
            double startTime = System.nanoTime();
            double val = this.lucas(n);
            double endTime = System.nanoTime();
            System.out.println(n + "th value = " + val + ". Time taken: " + (endTime - startTime) + " ns");
            this.testLucas(n - 1);
        }
    }
    /**
     * Tests the this.lucas(int n) function for time of completion
     * @param n n integer which n>1 for the this.lucas(n) function
     * @return the double value in nanoseconds of the time it took to run the this.lucas(n) function
     */
    public double timeLucas(int n) {
        double startTime = System.nanoTime();
        double val = this.lucas(n);
        double endTime = System.nanoTime();
        return endTime - startTime;
    }

}
