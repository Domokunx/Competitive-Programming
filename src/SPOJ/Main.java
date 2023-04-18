package SPOJ;

import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        // try 999_900_000 1_000_000_000
        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            int lowerLimit = scanner.nextInt();
            int upperLimit = scanner.nextInt();
            segmentedSieve(upperLimit + 1, lowerLimit);
            System.out.println();
        }
    }

    // Obtain the first (sqrt(n) primes?)
    private static ArrayList<Integer> simpleSieve(int limit, int lowLim){
        boolean[] isPrimeArray = new boolean[limit + 1];
        Arrays.fill(isPrimeArray, true);
        for (int i = 2; i * i <= limit; i++) {
            if (!isPrimeArray[i]) continue;
            for (int j = i * i; j <= limit; j += i) {
                isPrimeArray[j] = false;
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isPrimeArray.length; i++) {
            if (isPrimeArray[i]) {
                primes.add(i);
                if (i >= lowLim)
                    System.out.println(i);
            }
        }
        return primes;
    }
    private static void segmentedSieve(int limit, int lowLim){
        int segmentSize  = (int) Math.floor(Math.sqrt(limit - lowLim));
        int sqrtLimit = (int) Math.floor(Math.sqrt(limit));
        ArrayList<Integer> primes = simpleSieve(sqrtLimit, lowLim);
        HashSet<Integer> primeSet = new HashSet<>(primes);

        int lowerLimit = Math.max(lowLim, 2);
        int upperLimit = lowerLimit + segmentSize;

        while (lowerLimit <= limit) {
            if (upperLimit >= limit) // For last segment, ensures we do not go above limit
                upperLimit = limit;

            boolean[] isPrimeArray = new boolean[upperLimit - lowerLimit];
            Arrays.fill(isPrimeArray, true);
            for (int prime : primeSet) {
                // Find lowest multiple of currentPrime within the segment to start the loop with
                int startingInt = (int) Math.floor(lowerLimit / (double) prime) * prime;
                if (startingInt < lowerLimit)
                    startingInt += prime;

                for (int i = startingInt; i < upperLimit; i += prime) {
                    isPrimeArray[i - lowerLimit] = false;
                }
            }
            for (int i = lowerLimit; i < upperLimit; i++) {
                if (isPrimeArray[i - lowerLimit])
                    System.out.println(i);
            }
            // Move to next segment
            lowerLimit += segmentSize;
            upperLimit += segmentSize;
        }
    }
}