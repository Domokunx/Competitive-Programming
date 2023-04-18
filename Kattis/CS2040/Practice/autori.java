package Kattis.CS2040.Practice;

import java.util.Scanner;

public class autori {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 65 && c <= 90)
                result += c;
        }
        System.out.println(result);
    }
}
