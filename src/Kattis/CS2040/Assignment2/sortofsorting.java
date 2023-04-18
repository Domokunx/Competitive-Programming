package Kattis.CS2040.Assignment2;

import java.util.Scanner;

public class sortofsorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            short n = scanner.nextShort();
            if (n == 0) break;

            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = scanner.next();
            }

            sortByFirstTwoAlphabets(names);
            for (String name : names) {
                System.out.println(name);
            }
            System.out.println(" ");
        }
    }

    private static void sortByFirstTwoAlphabets(String[] names) {
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].charAt(0) > names[j].charAt(0)) {
                    swapPosition(names, i, j);
                } else if (names[i].charAt(0) == names[j].charAt(0)) {
                    if (names[i].charAt(1) > names[j].charAt(1)) {
                        swapPosition(names, i, j);
                    }
                }
            }
        }
    }

    private static void swapPosition(String[] names, int i, int j) {
        String temp = names[i];
        names[i] = names[j];
        names[j] = temp;
    }
}

