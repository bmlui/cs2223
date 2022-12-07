import java.util.Arrays;

public class HashTableClosedHashing {
    private String[] array;
   private int size;
    private int itemsInArray = 0;
    Hash h;

    /**
     * Creates a new hash table with the given size.
     *
     * @param size The size of the hash table.
     */
    public HashTableClosedHashing(int size) {
        this.size = size;
        array = new String[size];
        Arrays.fill(array, "-1");
        this.h = new Hash(123, 293);
    }

    /**
     * Creates a new hash table with the given size and C value. The C value is used in the hash function.
     *
     * @param size The size of the hash table.
     * @param C    is a constant larger than every ord(c)
     */
    public HashTableClosedHashing(int size, int C) {
        this.size = size;
        array = new String[size];
        Arrays.fill(array, "-1");
        this.h = new Hash(C, size);
    }

    /**
     * Inserts an array of strings into the hash table.
     *
     * @param input The array of strings to insert.
     */
    public void insertArray(String[] input) {
        for (int i = 0; i < input.length; i++) {
            insert(input[i]);
        }
    }

    /**
     * Inserts a string into the hash table.
     *
     * @param input The string to insert.
     */
    public void insert(String input) {
        if (this.getKey(input) == -1) {
            int index = h.hash(input);
            int counter = 0;
            while (array[index] != "-1" && counter <= size) {
                System.out.println("Collision at index " + index + " for " + input);
                index++;
                index %= size;
                counter++;
            }
            if (counter >= size) {
                System.out.println("No more space in the array!");
            } else {
                System.out.println("Inserted " + input + " at index " + index);
                array[index] = input;
                itemsInArray++;
            }

        }
    }

    /**
     * Returns the key of a string in the hash table.
     *
     * @param input The string to get the key of.
     * @return The key of the string.
     */
    public int getKey(String input) {
        int index = h.hash(input);
        int counter = 0;
        while (array[index] != "-1" && counter <= size) {
            if (array[index].equals(input)) {
                return index;
            }
            index++;
            index %= size;
            counter++;
        }
        return -1;
    }

    /**
     * Returns the value of a string in the hash table.
     *
     * @param key The key of the string to get the value of.
     * @return The value of the string.
     */
    public String getValue(int key) {
        return array[key];
    }

    /**
     * Counts the amount of non-empty addresses in the hash table.
     *
     * @return The amount of non-empty addresses in the hash table.
     */
    public int getItemsInArray() {
        return itemsInArray;
    }

    public int getSize() {
        return size;
    }

    /**
     * Gets the longest empty area of the hashtable
     * @return an int array with the start (index 0) and end (index 1) of the longest empty area,
     * and the length of the area (index 2)
     */
    public int[] longestEmptyArea() {
        int[] longest = new int[3];
        int[] current = new int[3];
        int totalCount = 0;
        for (int i = 0; i < array.length; i++) {
            int counter = 0;
            if (array[i] == "-1") {
                current[0] = i;
                current[1] = i;
                while (array[i] == "-1" && counter <= size) {
                    current[1] = i;
                    counter++;
                    current[2] = counter;
                    i++;
                    i %= this.size;
                }
                if (current[2] > longest[2]) {
                    longest = current;
                }
            }
            totalCount += counter;
            if (totalCount >= size) {
                return longest;
            }
        }
        return longest;
    }

    /**
     * Gets the longest cluster in the hash table
     * @return an int array with the start (index 0) and end (index 1) of the longest cluster,
     * and length of the cluster (index 2)
     */
    public int[] longestCluster() {
        int[] longest = new int[3];
        int[] current = new int[3];
        int totalCount = 0;
        for (int i = 0; i < array.length; i++) {
            int counter = 0;
            if (array[i] != "-1") {
                current[0] = i;
                current[1] = i;
                while (array[i] != "-1" && counter <= size) {
                    current[1] = i;
                    counter++;
                    current[2] = counter;
                    i++;
                    i %= this.size;
                }
                if (current[2] > longest[2]) {
                    longest = current;
                }
            }
            totalCount += counter;
            if (totalCount >= size) {
                return longest;
            }
        }
        return longest;
    }

}
