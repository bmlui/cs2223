import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Hash hash = new Hash(123, 293);
        System.out.println(hash.hash("Hear"));
        System.out.println(hash.hash("much"));
        System.out.println(hash.hash("By"));

        HashTableClosedHashing hashTable = new HashTableClosedHashing(293);

        String[] input = {"Hello", "world", "!"};
        // hashTable.insertArray(input);


        File file = new File("/Users/blui/Documents/Git/cs2223/hw5/src/EdgarAllanPoeBellsB2022groomed.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String[] stArr;
        String st;
        while (true) {
            try {
                st = br.readLine();
                if (!((st) != null)) break;
                st = (st.replace("�", ""));
                stArr = st.split(" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Hash.printArr(stArr);
            hashTable.insertArray(stArr);
        }
        System.out.println(hashTable.getItemsInArray());
        hash.printArr(hashTable.longestEmptyArea());
        hash.printArr(hashTable.longestCluster());
    }

}
