package Kattis.Others;

import java.util.Scanner;

public class symmetricorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int set = 1;
        while (true) {
            int nameCount = scanner.nextInt();
            if (nameCount == 0) return;
            String[] names = new String[nameCount];
            for (int counter = 0, i = 0, j = nameCount - 1; counter < nameCount; counter++) {
                if (names[i] != null) {
                    names[j] = scanner.next();
                    j--;
                    i++;
                }
                else {
                    names[i] = scanner.next();
                }
            }
            System.out.println("SET " + set++);
            for (String name : names)
                System.out.println(name);
        }
    }
}
