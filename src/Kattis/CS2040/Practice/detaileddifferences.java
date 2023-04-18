package Kattis.CS2040.Practice;

import java.util.Scanner;

public class detaileddifferences {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        short loop = scanner.nextShort();
        for (int i = 0; i < loop; i++) {
            StringBuilder difference = new StringBuilder();
            String first = scanner.next();
            String second = scanner.next();
            for (int j = 0; j < first.length(); j++) {
                difference.append(first.charAt(j) == second.charAt(j) ? "." : "*");
            }
            System.out.println(first);
            System.out.println(second);
            System.out.println(difference);
        }
    }
}
