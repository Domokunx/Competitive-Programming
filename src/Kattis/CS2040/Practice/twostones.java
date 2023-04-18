package Kattis.CS2040.Practice;

import java.util.Scanner;

public class twostones {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int stones = scanner.nextInt();
        if (stones % 2 == 0) System.out.println("Bob");
        else System.out.println("Alice");
    }
}
