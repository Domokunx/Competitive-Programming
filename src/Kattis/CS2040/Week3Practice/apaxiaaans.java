package Kattis.CS2040.Week3Practice;

import java.util.Scanner;

public class apaxiaaans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();
        var shortName = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            while (i < name.length() - 1 && name.charAt(i) == name.charAt(i + 1)) {
                i++;
            }
            shortName.append(name.charAt(i));
        }
        System.out.println(shortName);
    }
}
