package Kattis.Others;

import java.util.Scanner;

public class odd {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        byte count = scanner.nextByte();
        for (int i = 0; i < count; i++) {
            byte number = scanner.nextByte();
            if (number % 2 == 0) System.out.println(number + " is even");
            else System.out.println(number + " is Kattis.CS2040.Others.odd");
        }
    }
}
