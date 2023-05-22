package hackerhank.interview.preparation.kit.dictionaries.and.hashmaps;

import java.io.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;

class TwoStrings {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {

        String theyHaveSameValue = "NO";

        int[] s1Array = s1.chars().sorted().distinct().toArray();
        int[] s2Array = s2.chars().sorted().distinct().toArray();

        for (int s1Int : s1Array) {
            for (int s2Int : s2Array) {
                if (s1Int == s2Int) {
                    theyHaveSameValue = "YES";
                    break;
                }
            }
        }
        return theyHaveSameValue;
    }

}

class TwoStringsSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = TwoStrings.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
