package Kattis.CS2040.Week4Practice;

import java.util.Scanner;

public class sumkindofproblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int setNumber = scanner.nextInt();
            int dataRange = scanner.nextInt();
            int sum = sumOfNInt(dataRange);
            int sumOdd = sumOfNIntOdd(dataRange, 1);
            int sumEven = sumOfNIntEven(dataRange, 2);

            System.out.println(setNumber + " " + sum + " " + sumOdd + " " + sumEven);
        }
    }

    private static int sumOfNInt(int dataRange) {
        while (dataRange > 0) {
            return dataRange + sumOfNInt(--dataRange);
        }
        return 0;
    }

    private static int sumOfNIntOdd(int dataRange, int start) {
        while (dataRange > 0) {
            return start + sumOfNIntOdd(--dataRange, start + 2);
        }
        return 0;
    }

    private static int sumOfNIntEven(int dataRange, int start) {
        while (dataRange > 0) {
            return start + sumOfNIntEven(--dataRange, start + 2);
        }
        return 0;
    }
}
