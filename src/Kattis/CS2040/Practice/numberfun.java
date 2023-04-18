package Kattis.CS2040.Practice;

import java.util.Scanner;

public class numberfun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loop = scanner.nextInt();
        for (int i = 0; i < loop; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if (canAdd(a, b, c) || canDivide(a, b, c) || canMultiply(a, b ,c) || canSubtract(a, b, c)) {
                System.out.println("Possible");
            }
            else System.out.println("Impossible");
        }
    }

    private static boolean canAdd (int a, int b, int c) {
        return a + b == c;
    }

    private static boolean canSubtract (int a, int b, int c) {
        return (a > b) ? (a - b == c) : (b - a == c);
    }

    private static boolean canMultiply (int a, int b, int c) {
        return a * b == c;
    }

    private static boolean canDivide (int a, int b, int c) {
        return (a > b) ? ((float) a / b == c) : ((float) b / a == c);
    }
}
