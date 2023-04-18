package Kattis.CS2040.Week7Practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boatparts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int partsCount = scanner.nextInt();
        int dayCount = scanner.nextInt();
        Set<String> partsReplaced = new HashSet<>(partsCount);
        for (int i = 0; i < dayCount; i++) {
            partsReplaced.add(scanner.next());
            if (partsReplaced.size() == partsCount) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("paradox avoided");
    }
}
