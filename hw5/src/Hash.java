public class Hash {
private int C;
private int m;

    /**
     * Creates a new hash function.
     * @param C The constant to use in the hash function.
     * @param m The size of the hash table.
     */
    public Hash(int C, int m) {
        this.C = C;
        this.m = m;
    }
    /**
     * Hashes a string using the hashing algorithm on page 269 of the textbook.
     * @param input The string to hash.
     * @return The hashed string.
     */
    public int hash(String input) {
        int h = 0;
        int s = input.length();
        for (int i = 0; i < s; i++) {
            h = (h * C + ord(input.charAt(i))) % m;
        }
        return h;
    }

    /**
     * Returns the ordinal value of a character.
     * @param c The character to get the ordinal value of.
     * @return The ordinal value of the character.
     */
    private static int ord(char c) {
        return (int) c;
    }

    /**
     * Prints an array of strings.
     * @param arr The array of strings to print.
     */
    public static void printArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    /**
     * Prints an array of ints.
     * @param arr The array of ints to print.
     */
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
