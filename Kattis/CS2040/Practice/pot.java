package Kattis.CS2040.Practice;

import java.util.Scanner;

public class pot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int loop = scanner.nextInt();
        for (int i = 0; i < loop; i++) {
            int input = scanner.nextInt();
            int base = input / 10;
            byte power = (byte) (input % 10);
            sum += Math.pow(base, power);
        }
        System.out.println(sum);
    }
}
