package Kattis.CS2040.Practice;

import java.util.Scanner;

public class lastfactorialdigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte loop = scanner.nextByte();

        for (int i = 0; i < loop; i++) {
            byte digit = scanner.nextByte();
            int factorial = 1;
            for (int j = 1; j <= digit; j++) {
                factorial *= j;
            }
            System.out.println(factorial % 10);
        }
    }
}
