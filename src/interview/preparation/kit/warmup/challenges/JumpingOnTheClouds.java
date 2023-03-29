package interview.preparation.kit.warmup.challenges;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class JumpingOnTheClouds {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {

        int numberOfJumps = 0;

        int currentIndex = 0;

        while (true) {

            if ((currentIndex + 1) == c.size()) {
                break;
            } else if ((currentIndex + 2) == c.size()) {
                numberOfJumps++;
                break;
            }

            if (c.get(currentIndex + 2) == 0) {
                currentIndex += 2;
            } else {
                currentIndex++;
            }
            numberOfJumps++;
        }

        return numberOfJumps;

    }

}

class JumpingOnTheCloudsSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = JumpingOnTheClouds.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
