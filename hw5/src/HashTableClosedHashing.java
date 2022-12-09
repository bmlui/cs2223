import java.util.Arrays;
import java.util.HashMap;

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
        this.array = new String[size];
        Arrays.fill(this.array, "-1");
        this.h = new Hash(123, size);
    }

    /**
     * Creates a new hash table with the given size and C value. The C value is used in the hash function.
     *
     * @param size The size of the hash table.
     * @param C    is a constant larger than every ord(c)
     */
    public HashTableClosedHashing(int size, int C) {
        this.size = size;
        this.array = new String[size];
        Arrays.fill(this.array, "-1");
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
        if (input.equals(null) | input.equals("")) {
            return;
        } else if (this.getKey(input) == -1) { // checks for duplicates
            int index = h.hash(input); // gets the starting index of the string
            int counter = 0;
            while (array[index] != "-1" && counter < size) {
                // System.out.println("Collision at index " + index + " for " + input);
                index++;
                index %= size;
                counter++;
            }
            if (counter >= size) {
                System.out.println("No more space in the array!");
            } else {
                //  System.out.println("Inserted " + input + " at index " + index);
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

    /**
     * Gets the size of the hash table.
     *
     * @return The size of the hash table.
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the longest empty area of the hashtable
     *
     * @return an int array with the start (index 0) and end (index 1) of the longest empty area,
     * and the length of the area (index 2)
     */
    public int[] longestEmptyArea() {
        int[] longest = new int[3];
        int[] current = new int[3];
        int totalCount = 0;
        for (int i = 0; i < this.size; i++) {
            int counter = 0;
            if (this.array[i] == "-1") {
                current[0] = i;
                current[1] = i;
                while (this.array[i] == "-1" && counter <= this.size) {
                    current[1] = i;
                    counter++;
                    current[2] = counter;
                    i++;
                    i %= this.size;
                }
                if (current[2] > longest[2]) {
                    for (int j = 0; j < 3; j++) {
                        longest[j] = current[j];
                    }
                }
            }
            totalCount += counter;
            if (totalCount > this.size) {
                return longest;
            }
        }
        return longest;
    }

    /**
     * Gets the longest cluster in the hash table
     *
     * @return an int array with the start (index 0) and end (index 1) of the longest cluster,
     * and length of the cluster (index 2)
     */
    public int[] longestCluster() {
        int[] longest = new int[3];
        int[] current = new int[3];
        int totalCount = 0;
        for (int i = 0; i < this.size; i++) {
            int counter = 0;
            if (this.array[i] != "-1") {
                current[0] = i;
                current[1] = i;
                while (this.array[i] != "-1" && counter <= this.size) {
                    current[1] = i;
                    counter++;
                    current[2] = counter;
                    i++;
                    i %= this.size;
                }
                if (current[2] > longest[2]) {
                    for (int j = 0; j < 3; j++) {
                        longest[j] = current[j];
                    }
                }
            }
            totalCount += counter;
            if (totalCount > this.size) {
                return longest;
            }
        }
        return longest;
    }

    /**
     * Gets the string of the hash that is farthest from the key for the hash table
     *
     * @return a String array with the string (index 0) and the key (index 1) and the distance from hash (index 2)
     */
    public String[] farthestFromHash() {
        String[] farthest = new String[3];
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int hash = h.hash(array[i]);
            if (array[i] != "-1") {
                int distance = 0;
                if (hash > i) {
                    distance = this.size - hash + i;
                } else if (hash < i) {
                    distance = Math.abs(hash - i);
                }

                if (distance > max) {
                    max = distance;
                    farthest[0] = array[i];
                    farthest[1] = Integer.toString(i);
                    farthest[2] = Integer.toString(distance);
                }
            }
        }
        return farthest;
    }

    /**
     * @return
     */
    public int[] mostCommonHash() {
        int[] mostCommon = new int[2];
        int[] hashCount = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] != "-1") {
                int hash = h.hash(this.array[i]);
                hashCount[hash]++;
            }
        }
        for (int i = 0; i < hashCount.length; i++) {
            if (hashCount[i] != 0) {
                if (hashCount[i] > mostCommon[1]) {
                    mostCommon[0] = i;
                    mostCommon[1] = (hashCount[i]);
                }
            }
        }
        return mostCommon;

    }

    /**
     * Prints hash table with key/index, value, and hash value
     */
    public void print() {
        System.out.println("Key | Value | Hash");
        for (int i = 0; i < array.length; i++) {
            String hashval = "";
            if (array[i] != "-1") {
                hashval = Integer.toString(h.hash(array[i]));
            }
            System.out.println(i + "   " + array[i] + " " + hashval);
        }
    }


    public double getLoadFactor() {
        return ((double)this.getItemsInArray()/(double)this.getSize());
    }
}
