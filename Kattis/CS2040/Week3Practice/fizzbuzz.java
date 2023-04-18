package Kattis.CS2040.Week3Practice;

import java.util.Scanner;

public class fizzbuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short X = scanner.nextShort();
        short Y = scanner.nextShort();
        short N = scanner.nextShort();

        for (short i = 1; i <= N; i++) {
            if (isDivisibleByX(i, X) && isDivisibleByY(i, Y))
                System.out.println("FizzBuzz");
            else if (isDivisibleByX(i, X))
                System.out.println("Fizz");
            else if (isDivisibleByY(i, Y))
                System.out.println("Buzz");
            else System.out.println(i);
        }
    }

    private static boolean isDivisibleByX(short i, short X) {
        return i % X == 0;
    }

    private static boolean isDivisibleByY(short i ,short Y) {
        return i % Y == 0;
    }
}
