import java.util.Arrays;

public class MagicSquare {
    public MagicSquare() {
    }

    /**
     * Finds all the possible 4 combinations of numbers in the given numbers array that add to the total
     *
     * @param numbers array of numbers to find combos of
     * @param total   the total of 4 numbers to look for
     * @return the total combinations of 4 numbers in the array that add to total param
     */
    public int find4Combo(int numbers[], int total) {
        int counter = 0;
        for (int i = 0; i < numbers.length - 3; i++) {
            for (int j = i + 1; j < numbers.length - 2; j++) {
                for (int k = j + 1; k < numbers.length - 1; k++) {
                    for (int l = k + 1; l < numbers.length; l++) {
                        if (numbers[i] + numbers[j] + numbers[k] + numbers[l] == total) {
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }

    /**
     * @param numbers
     * @param total
     * @return
     */
    public int findAllCombo(int numbers[], int total) {
        int n = numbers.length;
        int counter = 0;
        for (int i = 0; i < (1 << n); i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    num += numbers[j];
                }
            }
            if (num == total) {
                counter++;
            }
        }
        return counter;
    }

    public int findComboRange(int numbers[]) {
        int endTotal = Arrays.stream(numbers).sum();
        int returnVal = 0;
        for (int i = 0; i<=endTotal; i++) {
           returnVal += findAllCombo(numbers, i);
        }
        return returnVal;
    }

    public void findGreatestCombo(int numbers[]) {
        int endTotal = Arrays.stream(numbers).sum();
        int greatestCombos = 0;
        int greatestSum = 0;
        for (int i = 0; i<=endTotal; i++) {
             int current = findAllCombo(numbers, i);
             if (current>greatestCombos) {
                 greatestCombos = current;
                 greatestSum = i;
             }

        }
        System.out.print(greatestCombos + " combinations are possible when looking for a sum of ");
        System.out.println(greatestSum);
    }
}
