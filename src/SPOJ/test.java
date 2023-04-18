package SPOJ;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input != 42) {
            System.out.println(input);
            input = scanner.nextInt();
        }
    }
}
