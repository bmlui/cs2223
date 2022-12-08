import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Question 1 & 2
        Hash hash = new Hash(123, 293);

        HashTableClosedHashing hashTable = new HashTableClosedHashing(293);
        Hash.fileHash("/Users/blui/Documents/Git/cs2223/hw5/src/EdgarAllanPoeBellsB2022groomed.txt", hashTable);
        hashTable.print();
          /* Extra testing stuff
        HashTableClosedHashing hashTableRaven = new HashTableClosedHashing(1000);
        Hash.fileHash("/Users/blui/Documents/Git/cs2223/hw5/src/RavenD2020.txt", hashTableRaven);
        hashTableRaven.print(); */


        // Question 3
        System.out.println("3a) Items in the array/non-empty addresses: " + hashTable.getItemsInArray() +", load factor: " + hashTable.getLoadFactor());
        int[] longestEmptyArea = hashTable.longestEmptyArea();
        System.out.println("3b) Longest empty area: " + longestEmptyArea[0] + " to " + longestEmptyArea[1] + " of length " + longestEmptyArea[2] );
        int[] longestCluster = (hashTable.longestCluster());
        System.out.println("3c) Longest cluster: " + longestCluster[0] + " to " + longestCluster[1] + " of length " + longestCluster[2]);
        int[] mostCommonHash = hashTable.mostCommonHash();
        System.out.println("3d) Most common hash: " + mostCommonHash[0] + " with " + mostCommonHash[1] + " items");
        String[] farthestFromHash = (hashTable.farthestFromHash());
        System.out.println("3e) Farthest from hash: " + farthestFromHash[0] + " at " + farthestFromHash[1] + " with distance/difference " + farthestFromHash[2]);

        // Question 4
        int[][] dikjstraMatrix = {{10},
                {0, 53, 10, 12, 0, 0, 0, 0, 0, 0},
                {53 ,0 ,33, 0, 2, 0, 101, 0, 0, 0},
                {10, 33, 0, 9, 30, 18, 0, 0, 0, 0},
                {12, 0, 9, 0, 0, 17, 0, 0, 6, 0},
                {0, 2, 30, 0, 0, 14, 123, 122, 0, 0},
                {0, 0, 18, 17, 14, 0, 0, 137, 7, 0},
                {0, 101, 0, 0, 123, 0, 0, 8, 0, 71},
                {0, 0, 0, 0, 122, 137, 8, 0, 145, 66},
                {0, 0, 0, 6, 0, 7, 0, 145, 0, 212},
                {0, 0, 0, 0, 0, 0, 71, 66, 212, 0}};

        Dijkstra.shortestDistance(dikjstraMatrix, 0, 4);
        Dijkstra.shortestDistance(dikjstraMatrix, 4, 9);
        Dijkstra.shortestDistance(dikjstraMatrix, 0, 9);
        }





    }


