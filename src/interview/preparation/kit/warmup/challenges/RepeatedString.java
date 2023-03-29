package interview.preparation.kit.warmup.challenges;

import java.io.*;

class RepeatedString {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {

        long sTimesInN = n/s.length();
        long remainder = n%s.length();
        long counter= 0;

        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i)=='a') counter++;
        }

        counter *= sTimesInN;
        s = s.substring(0, (int) remainder);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='a')counter++;
        }

        return counter;
    }

}

class RepeatedStringSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = RepeatedString.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
