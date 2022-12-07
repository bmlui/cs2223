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
        Hash.fileHash("/Users/blui/Documents/Git/cs2223/hw5/src/EdgarAllanPoeBellsB2022groomed.txt", hashTable);
        System.out.println(hashTable.getItemsInArray());
        int[] longestEmptyArea = hashTable.longestEmptyArea();
        int[] longestCluster =(hashTable.longestCluster());
        String[] farthestFromHash = (hashTable.farthestFromHash());
        hashTable.print();

        /* Extra testing stuff
        HashTableClosedHashing hashTableRaven = new HashTableClosedHashing(1000);
        Hash.fileHash("/Users/blui/Documents/Git/cs2223/hw5/src/RavenD2020.txt", hashTableRaven);
        hashTableRaven.print(); */


    }

}
