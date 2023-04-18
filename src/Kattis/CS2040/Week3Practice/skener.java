package Kattis.CS2040.Week3Practice;

import java.util.Scanner;

public class skener {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte Z = scanner.nextByte();
        byte C = scanner.nextByte();
        byte Zr = scanner.nextByte();
        byte Zc = scanner.nextByte();

        for (int i = 0; i < Z; i++) {
        var sb = new StringBuilder();
        String input = scanner.next();
           for (int j = 0; j < C; j++)
               for (int k = 0; k < Zc; k++)
                   sb.append(input.charAt(j));

           for (int j = 0; j < Zr; j++)
               System.out.println(sb);
       }
    }
}
