package Kattis.Others;

import java.util.Scanner;

public class fizzbuzz {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        byte X = scanner.nextByte();
        byte Y = scanner.nextByte();
        byte N = scanner.nextByte();

        for (int i = 1; i <= N; i++) {
            if (i % X == 0 && i % Y == 0) System.out.println("FizzBuzz");
            else if (i % X == 0) System.out.println("Fizz");
            else if (i % Y == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }
}
