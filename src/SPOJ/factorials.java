package SPOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class factorials {
    public static void main(String[] args) {
         // Output Z(N), where Z is a function that outputs the number of 0s at the end of N!
        // Pattern: Every 5 increment of N, +1 trailing zero, if square of 5, then add another power
        // EG:
        // Z(5) = 1 (5)
        // Z(10) = 2 (2*5)
        // Z(15) = 3 (3*5)
        // Z(20) = 4 (4*5)
        // Z(25) = 6 (5^2) -> N/5 + N/25 -> 5 + 1
        // Z(30) = 7 (2*3*5)
        // Z(35) = 8 (5*7)
        // Z(40) = 9 (2^3*5)
        // Z(45) = 10 (3^2*5)
        // Z(50) = 12 (2*5^2)
        // Z(100) = 24 (2^2*5^2) -> N/5 + N/25 -> 20 + 4
        // Problem: Input number is too big to be efficient
        // Probably prime factorise 5? N / 5 + no of 5 prime factors
        // Basically, a trailing zero only appears every time we multiply by 10 (2 * 5)
        // So we just need to count the number for 2 and 5 factors, and take the smaller of them
        // there are way more factors of 2 (just count the even numbers)
        // so just calculate the number of 5, and account the powers of 5 as they create extra factors of 10, leading to more 0s.
        Scanner scanner = new Scanner(System.in);

        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            long N = scanner.nextLong();
            long additionalZeros = 0;
            for (int j = 1; N >= Math.pow(5, j); j++) {
                additionalZeros += (N / Math.pow(5 ,j));
            }
            System.out.println(additionalZeros);
        }
    }

    // Recursive Style
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : (n / 5) + trailingZeroes(n / 5);
    }

    // Used this to find the pattern
    private static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) return BigInteger.ONE;
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
