package hackerhank.interview.preparation.kit.dictionaries.and.hashmaps;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class CountTriplets {

    // 1 < 2 < 4
    // 1 < 2 < 4

    // 1 < 3 < 9
    // 1 < 3 < 9
    // 3 < 9 < 27
    // 3 < 9 < 27
    // 9 < 27 < 81
    // 9 < 27 < 81

    // 1 < 5 < 25
    // 1 < 5 < 25
    // 5 < 25 < 125
    // 5 < 5 < 125


    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        long numOfTriplets = 0L;

        boolean isDuplicated = false;
        int indexOfDuplicated = 0;
        int indexToStart = 0;
        Long lastElement = 0L;

        int numberOfElements = 0;

        for (int i = 0; i < arr.size(); i++) {

            if (numberOfElements == 0) {
                indexToStart = i;
            }

            numberOfElements++;

            if (isDuplicated && i == indexOfDuplicated) {
                isDuplicated = false;
                continue;
            }

            if (numberOfElements == 3) {
                numOfTriplets++;
                numberOfElements = 0;
            }

            if (arr.get(i).equals(lastElement) || arr.get(i).equals(arr.get(i+1))) {
                isDuplicated = true;
                indexOfDuplicated = i;
            }

            lastElement = arr.get(i);

            if (isDuplicated && numberOfElements == 3) {
                i = (indexToStart -1);
            }

        }

        return numOfTriplets;
    }

}


class CountTripletsSolution {
    public static void main(String[] args) throws IOException {
/*        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());*/

        List<Long> arr = new ArrayList<>();
        arr.add(1L);
        arr.add(3L);
        arr.add(9L);
        arr.add(9L);
        arr.add(27L);
        arr.add(81L);

        long ans = CountTriplets.countTriplets(arr, 5);
/*
        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}