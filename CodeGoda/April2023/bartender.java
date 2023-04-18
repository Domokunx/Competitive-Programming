//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//class Solution {
//
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner scanner = new Scanner(System.in);
//
//        int N = scanner.nextInt();
//        int islandCount = scanner.nextInt();
//        ArrayList<Integer> distinctScores = new ArrayList<Integer>(islandCount);
//        for (int i = 0; i < islandCount; i++) {
//            distinctScores.add(scanner.nextInt());
//        }
//
//        ArrayList<Integer> primeFactors = new ArrayList<>();
//        // Factorise N
//        for (int i = 2; i < N; i++) {
//            while (N % i == 0) {
//                primeFactors.add(i);
//                N /= i;
//            }
//        }
//        if (N > 2)
//            primeFactors.add(N);
//        System.out.println(primeFactors);
//
//        // Finding all possible distinctiveness Scores
//        HashSet<Integer> distinctSet = new HashSet<>();
//        subsetSummation(primeFactors, 0, primeFactors.size() - 1, 0, distinctSet);
//
//        System.out.println(distinctSet);
//        if (distinctSet.contains())
//
//    }
//    private static void subsetSummation(ArrayList<Integer> primes, int leftPtr, int rightPtr, int currentSum, HashSet<Integer> set) {
//        // leftptr exceeds right, subset completed
//        if (leftPtr > rightPtr) {
//            set.add(currentSum);
//            return;
//        }
//        // Subset include primeFactors[l]
//        subsetSummation(primes, leftPtr + 1, rightPtr, currentSum + primes.get(leftPtr), set);
//
//        //Without l
//        subsetSummation(primes, leftPtr + 1, rightPtr, currentSum, set);
//    }
//}