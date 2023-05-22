package hackerhank.interview.sample.tests;

public class FizzBuzz {

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            printFizzBuzz(i);
        }
    }

    private static void printFizzBuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0) System.out.println("FizzBuzz");
        else if (n % 3 == 0) System.out.println("Fizz");
        else if (n % 5 == 0) System.out.println("Buzz");
        else System.out.println(n);
    }

    public static void main(String[] args) {
        fizzBuzz(15);
    }

}
