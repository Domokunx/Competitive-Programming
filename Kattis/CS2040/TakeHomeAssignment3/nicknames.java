package Kattis.CS2040.TakeHomeAssignment3;

import java.util.Scanner;

public class nicknames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nameCount = scanner.nextInt();
        String[] names = new String[nameCount];
        for (int i = 0; i < nameCount; i++) {
            String name = scanner.next();
            names[i] = name;
        }
        int nicknameCount = scanner.nextInt();
        String[] nicknames = new String[nicknameCount];
        for (int i = 0; i < nicknameCount; i++) {
            String nickname = scanner.next();
            nicknames[i] = nickname;
        }


    }
}
