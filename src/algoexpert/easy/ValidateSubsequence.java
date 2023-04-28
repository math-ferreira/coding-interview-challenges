package algoexpert.easy;

import java.util.ArrayList;
import java.util.List;

public class ValidateSubsequence {
    public static boolean isValidSubsequenceSolutionOne(List<Integer> array, List<Integer> sequence) {

        int arrayPosition = 0;
        boolean valueWasReached;

        for (int i = 0; i < sequence.size(); i++) {
            valueWasReached = false;
            for (int j = arrayPosition; j < array.size(); j++) {
                if (sequence.get(i).equals(array.get(j))) {
                    arrayPosition = j + 1;
                    valueWasReached = true;
                    break;
                }
            }
            if (!valueWasReached) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidSubsequenceSolutionTwo(List<Integer> array, List<Integer> sequence) {

        int sequenceIndex = 0;

        for (Integer item : array) {
            if (item.equals(sequence.get(sequenceIndex))) {
                sequenceIndex++;
            }
            if (sequenceIndex == sequence.size()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(22);
        list.add(25);
        list.add(6);
        list.add(-1);
        list.add(8);
        list.add(10);

        List<Integer> subList = new ArrayList<>();
        subList.add(1);
        subList.add(6);
        subList.add(-1);
        subList.add(10);

        System.out.println(isValidSubsequenceSolutionTwo(list, subList));
    }
}
