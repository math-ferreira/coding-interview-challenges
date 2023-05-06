package algoexpert.easy;

import java.util.Arrays;

public class NonConstructibleChange {

/*    public static int nonConstructibleChangeSolutionOne(int[] coins) {

        int[] sortedCoins = Arrays.stream(coins).sorted().toArray();

        int minSumToSearch = 1;

        int roundSum = 0;

        int lastIndexStarted = 0;

        for (int i = 0; i < sortedCoins.length; i++) {
            roundSum += sortedCoins[i];
            if (roundSum == minSumToSearch) {
                minSumToSearch++;
                roundSum = 0;
                i = -1;
            }
            else if (roundSum > minSumToSearch) {
                roundSum = 0;
                i = lastIndexStarted;
                lastIndexStarted++;
            }
        }


        return minSumToSearch;
    }*/

    public static int nonConstructibleChangeSolutionOne(int[] coins) {

        int[] sortedCoins = Arrays.stream(coins).sorted().toArray();
        int minValueToReach = 0;

        for (int coin : sortedCoins) {
            if (coin <= (minValueToReach + 1)) {
                minValueToReach += coin;
            } else if (coin > minValueToReach) {
                return minValueToReach + 1;
            }
        }

        return minValueToReach;
    }

    public static int nonConstructibleChangeSolutionTwo(int[] coins) {

        int[] sortedCoins = Arrays.stream(coins).sorted().toArray();
        int minValueToReach = 0;

        for (int coin : sortedCoins) {
            if (coin <= (minValueToReach + 1)) {
                minValueToReach += coin;
                continue;
            }
            return minValueToReach + 1;
        }

        return minValueToReach + 1;
    }


    public static void main(String[] args) {
        int[] coinsArray = new int[]{5, 7, 1, 1, 2, 3, 22};

        System.out.println(nonConstructibleChangeSolutionTwo(coinsArray));

    }

}
