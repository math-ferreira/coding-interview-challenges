package hackerhank.interview.preparation.kit.arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class TwoDArrayDS {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {

        List<Integer> hourglassesList = new ArrayList<>();


        for (int i = 0; i < arr.size() - 1; i++) {

            if ((i + 2) > arr.size() - 1) {
                break;
            }

            for (int j = 0; i < arr.size() - 1; j++) {

                if ((j + 2) > arr.size() - 1) {
                    break;
                }

                int sumTopRows = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2);
                int middleRow = arr.get(i + 1).get(j + 1);
                int sumBottomRow = arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                hourglassesList.add(sumTopRows + middleRow + sumBottomRow);

            }
        }

        return Collections.max(hourglassesList);

    }

}

class TwoDArrayDSSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = TwoDArrayDS.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
