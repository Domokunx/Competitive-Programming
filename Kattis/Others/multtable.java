package Kattis.Others;

import java.util.Scanner;

public class multtable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double multiplierLimit = scanner.nextDouble();
        double target = scanner.nextDouble();
        int divisibleCount = 0;
        for (double i = 1; i <= target; i++) {
            if (i > multiplierLimit) break;
            double quotient = target / i;
            if (quotient % 1 == 0 && quotient <= multiplierLimit) divisibleCount++;
        }
        System.out.println(divisibleCount);
    }
}