package SPOJ;

import java.util.*;

public class primes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int limit = scanner.nextInt();
        ArrayList<Integer> primes = segmentedSieve(limit);
        System.out.println(Arrays.toString(primes.toArray()));

    }
    // Sieve of Eratosthenes
    // For example: find all primes equal or less than 50(limit)
    // First, create an array of size (limit)
    // Traverse array from 2(smallest prime), and mark all multiples that are greater than its square
    // EG: 2 -> marks 4, 6, 8, 12...
    // 3 -> marks 9, 12 (6 is skipped as it is less than its square, alr considered as multiple of 2)
    // Recursively traverse, moving from unmarked numbers until limit
    private static ArrayList<Integer> simpleSieve(int limit) {
        boolean[] isPrimeArray = new boolean[limit + 1];
        Arrays.fill(isPrimeArray, true);
        for (int i = 2; i * i < limit; i++) {
            if (!isPrimeArray[i]) continue;
            for (int j = i * i; j < limit; j += i) {
                isPrimeArray[j] = false;
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isPrimeArray.length; i++) {
            if (isPrimeArray[i])
                primes.add(i);
        }
        return primes;
    }

    // Requires understanding of simple sieve first
    // Simple Sieve with range sqrt(limit) and store primes found in an array
    // using that array as reference, check the other segmented ranges (faster as there is locality of ref)
    private static ArrayList<Integer> segmentedSieve(int limit) {
        int newLimit = (int) Math.floor(Math.sqrt(limit));
        ArrayList<Integer> primes = simpleSieve(newLimit);
        HashSet<Integer> primeSet = new HashSet<>(primes);

        int lowerLimit = newLimit;
        int upperLimit = lowerLimit * 2; // Maintains segment size of sqrt(limit)

        while (lowerLimit <= limit) {
            if (upperLimit >= limit) // For last segment, ensures we do not go above limit
                upperLimit = limit;

            boolean[] isPrimeArray = new boolean[newLimit + 1];
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
                    primes.add(i);
            }
            // Move to next segment
            lowerLimit += newLimit;
            upperLimit += newLimit;
        }
        return primes;
    }
}
