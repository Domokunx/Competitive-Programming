package Kattis.Others;

import java.util.Scanner;

public class parking2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int storeCount = scanner.nextInt();
            for (int j = 0; j < storeCount; j++) {
                int store = scanner.nextInt();
                if (min > store)
                    min = store;

                if (max < store)
                    max = store;
            }
            System.out.println((max - min) * 2);
        }
    }
}
