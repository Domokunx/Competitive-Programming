package Kattis.CS2040.TakeHomeAssignment2;

import java.util.Scanner;

public class joinstrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stringCount = scanner.nextInt();
        String[] strings = new String[stringCount];

        for (int i = 0; i < stringCount; i++) {
            strings[i] = scanner.next();
        }

        int lastStringIndex = 0;
        for (int i = 0; i < stringCount - 1; i++) {
            int toIndex = scanner.nextInt() - 1;
            int fromIndex = scanner.nextInt() - 1;
            concat(strings,toIndex,fromIndex);
            if (i == stringCount - 2)
                lastStringIndex = toIndex;
        }
        System.out.println(strings[lastStringIndex]);
    }

    private static void concat(String[] strings, int to, int from) {
        var sb = new StringBuilder(strings[to]);
        sb.append(strings[from]);
        strings[to] = sb.toString();
        strings[from] = "";
    }
}
