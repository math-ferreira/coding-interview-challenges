package algoexpert.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class TwoNumberSum {

    public static int[] twoNumberSumSolutionOne(int[] array, int targetSum) {

        for (int i = 0; i < array.length; i++) {
            int positionI = array[i]; // O(1)
            for (int j = 0; j < array.length; j++) {
                int positionJ = array[j]; // O(1)
                if (i != j && (positionI + positionJ == targetSum)) {
                    return new int[]{positionI, positionJ};
                }
            }
        }

        return new int[0];
    }

    public static int[] twoNumberSumSolutionTwo(int[] array, int targetSum) {

        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            int valueToReach = targetSum - element; // X + Y = targetSum -> Y = targetSum - X

            if (hashTable.contains(valueToReach)) {
                return new int[]{element, valueToReach};
            }

            hashTable.put(element, valueToReach);
        }

        return new int[0];
    }

    public static int[] twoNumberSumSolutionThree(int[] array, int targetSum) {

        Set<Integer> hashTable = new HashSet<>();
        for (int number : array) {
            int valueToReach = targetSum - number; // X + Y = targetSum -> Y = targetSum - X
            if (hashTable.contains(valueToReach)) {
                return new int[]{number, valueToReach};
            }
            hashTable.add(number);
        }

        return new int[0];
    }


    public static void main(String[] args) {
        int[] test = new int[]{3, 5, -4, 8, 11, 1, -1, 6};

        int[] result = twoNumberSumSolutionThree(test, 10);
    }

}

