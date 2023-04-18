package Kattis.CS2040.Week4Practice;

import java.util.Scanner;

public class shatteredcake {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalWidth = scanner.nextInt();
        int Number = scanner.nextInt();
        int totalArea = 0;

        for (int i = 0; i < Number; i++) {
            int width = scanner.nextInt();
            int length = scanner.nextInt();

            totalArea += width * length;
        }
        System.out.println(totalArea / totalWidth);
    }
}
