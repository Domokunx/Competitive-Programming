package Kattis.CS2040.Week5Practice;

import java.util.Arrays;
import java.util.Scanner;

public class akcija {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bookCount = scanner.nextInt();
        int[] books = new int[bookCount];
        for (int i = 0; i < bookCount; i++) {
            books[i] = scanner.nextInt();
        }

        Arrays.sort(books);
        int booksToPay = (bookCount / 3) * 2 + (bookCount % 3);
        int totalPrice = 0;
        for (int i = bookCount - 1, j = 0; j < booksToPay; i--, j++) {
            totalPrice += books[i];
        }
        System.out.println(totalPrice);
    }
}
