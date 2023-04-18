package Kattis.CS2040.Assignment1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class t9spelling {
    private static Map<Character, String> hashmap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        hashmap.put('a', "2");
        hashmap.put('b', "22");
        hashmap.put('c', "222");
        hashmap.put('d', "3");
        hashmap.put('e', "33");
        hashmap.put('f', "333");
        hashmap.put('g', "4");
        hashmap.put('h', "44");
        hashmap.put('i', "444");
        hashmap.put('j', "5");
        hashmap.put('k', "55");
        hashmap.put('l', "555");
        hashmap.put('m', "6");
        hashmap.put('n', "66");
        hashmap.put('o', "666");
        hashmap.put('p', "7");
        hashmap.put('q', "77");
        hashmap.put('r', "777");
        hashmap.put('s', "7777");
        hashmap.put('t', "8");
        hashmap.put('u', "88");
        hashmap.put('v', "888");
        hashmap.put('w', "9");
        hashmap.put('x', "99");
        hashmap.put('y', "999");
        hashmap.put('z', "9999");
        hashmap.put(' ', "0");



        short testcases = scanner.nextShort();
        for (int i = 0; i < testcases; i++) {
            String message = scanner.next();
            var output = new StringBuilder();
            for (int j = 0; j < message.length(); j++) {
                if (j > 0 && isSameKey(message, j))
                    output.append(' ');

                output.append(hashmap.get(message.charAt(j)));
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static boolean isSameKey(String message, int index) {
        char c = message.charAt(index);
        char previousC = message.charAt(index - 1);
        return  (c >= 'a' && c <= 'c' && previousC >= 'a' && previousC <= 'c') ||
                (c >= 'd' && c <= 'f' && previousC >= 'd' && previousC <= 'f') ||
                (c >= 'g' && c <= 'i' && previousC >= 'g' && previousC <= 'i') ||
                (c >= 'j' && c <= 'l' && previousC >= 'j' && previousC <= 'l') ||
                (c >= 'm' && c <= 'o' && previousC >= 'm' && previousC <= 'o') ||
                (c >= 'p' && c <= 's' && previousC >= 'p' && previousC <= 's') ||
                (c >= 't' && c <= 'v' && previousC >= 't' && previousC <= 'v') ||
                (c >= 'w' && c <= 'z' && previousC >= 'w' && previousC <= 'z') ||
                (c == ' ' && previousC == ' ');

    }
}
