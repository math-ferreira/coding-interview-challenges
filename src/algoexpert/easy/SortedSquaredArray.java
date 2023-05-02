package algoexpert.easy;

import java.util.Arrays;

public class SortedSquaredArray {

    public static int[] sortedSquaredArraySolutionOne(int[] array) {

        return Arrays.stream(array)
                .map(item -> item * item)
                .sorted()
                .toArray();
    }

    public static int[] sortedSquaredArraySolutionTwo(int[] array) {

        int[] outputArray = new int[array.length];

        int smallestPointer = 0;
        int largestPointer = (array.length - 1);

        for (int i = array.length - 1; i >= 0; i--) {

            int smallestAbsoluteValue = Math.abs(array[smallestPointer]);
            int largestAbsoluteValue = Math.abs(array[largestPointer]);

            if (smallestAbsoluteValue >= largestAbsoluteValue) {
                outputArray[i] = smallestAbsoluteValue * smallestAbsoluteValue;
                smallestPointer++;
            } else {
                outputArray[i] = largestAbsoluteValue * largestAbsoluteValue;
                largestPointer--;
            }
        }

        return outputArray;
    }

    public static void main(String[] args) {
        int[] arrayOne = new int[]{-5, -3, 0, 1, 2, 5, 10, 25, 30}; // 0 1 4 9 25 25 100 625 900
        int[] arrayTwo = new int[]{1, 4, 9, 16, 25};

        System.out.println(
                Arrays.toString(sortedSquaredArraySolutionTwo(arrayTwo))
        );
    }
}
