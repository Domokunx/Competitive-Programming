package SPOJ;

import java.util.Arrays;
import java.util.Scanner;

public class divisorsummation {
    public static void main(String[] args) {
        //Given a natural number n (1 <= n <= 500000), please output the summation of all its proper divisors.
        //Definition: A proper divisor of a natural number is the divisor that is strictly less than the number.
        //e.g. number 20 has 5 proper divisors: 1, 2, 4, 5, 10, and the divisor summation is: 1 + 2 + 4 + 5 + 10 = 22.

        // Method 1: Brute force (with simple Sieve beforehand)
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        final int MAX_ARGUMENT = 500_000;
        boolean[] isPrimeArray= simpleSieve(MAX_ARGUMENT);
        for (int i = 0; i < testcases; i++) {
            int number = scanner.nextInt();
            // Special Case
            if (number == 1)
            {
                System.out.println(0);
                continue;
            }

            // Find primes
            if (isPrimeArray[number]) {
                System.out.println(1);
                continue;
            }

            // Brute force until the factor repeats
            int sum = 1;
            for (int j = 2, largestFactor = number; j < largestFactor; j++) {
                if (number % j == 0) {
                    int quotient = number / j;
                    sum += j + (quotient == j ? 0 : quotient);
                    largestFactor = quotient;
                }
            }
            System.out.println(sum);

            // Method 2: Sieve-like
            // iterating from 1 to MAX
            // just add the current value to its multiples
            int[] sieve = new int[MAX_ARGUMENT + 1];
            for (int k = 1; k <= MAX_ARGUMENT; k++) {
                for (int j = 2*k; j <= MAX_ARGUMENT; j += k) {
                    sieve[j] += k;
                }
            }
            System.out.println(sieve[number]);
        }
    }

    // To speed up search, if prime, print 1;
    private static boolean[] simpleSieve(int limit) {
        boolean[] isPrimeArray = new boolean[limit + 1];
        Arrays.fill(isPrimeArray, true);

        for (int i = 2; i * i <= limit; i++) {
            if (!isPrimeArray[i]) continue;
            for (int j = i * i; j <= limit; j += i) {
                isPrimeArray[j] = false;
            }
        }
        return isPrimeArray;
    }
}
