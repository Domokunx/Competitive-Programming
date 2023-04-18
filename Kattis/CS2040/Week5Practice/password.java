package Kattis.CS2040.Week5Practice;

import java.util.Scanner;
import java.util.TreeMap;

public class password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int passwords = scanner.nextInt();
        TreeMap<Double, String> map = new TreeMap<>();
        for (int i = 0; i < passwords; i++) {
            String password = scanner.next();
            double probability = scanner.nextDouble();

            map.put(probability, password);
        }
        double expectedAttempts = 0;
        for (double p : map.keySet()) {
            expectedAttempts += (p * passwords--);
        }
    System.out.println(expectedAttempts);
    }
}
