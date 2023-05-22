package hackerhank.interview.preparation.kit.warmup.challenges;

import java.io.*;

class CountingValley {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here

        int countingUphill = 0;
        int countingDownhill = 0;

        Boolean startValley = false;

        int numberOfValleysTraversed = 0;

        for (int i = 0; i < path.length(); i++) {

            if (path.charAt(i) == 'U') {
                countingUphill++;
            } else {
                countingDownhill++;
            }

            if (countingUphill == countingDownhill && startValley){
                numberOfValleysTraversed++;
            }

            if (countingUphill < countingDownhill) {
                startValley = true;
            } else {
                startValley = false;
            }

        }

        return numberOfValleysTraversed;
    }

}

class CountingValleySolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = CountingValley.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
