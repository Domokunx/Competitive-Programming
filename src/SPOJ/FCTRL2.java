package SPOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class FCTRL2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            System.out.println(factorial(BigInteger.valueOf(scanner.nextInt())));
        }
    }
    private static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) return BigInteger.ONE;
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
