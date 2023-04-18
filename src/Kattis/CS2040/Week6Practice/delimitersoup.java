package Kattis.CS2040.Week6Practice;

import java.util.*;

public class delimitersoup {
    private static List<Character> leftBrackets = Arrays.asList('(', '[', '{');
    private static List<Character> rightBrackets = Arrays.asList(')', ']', '}');
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        short length = scanner.nextShort();
        String line  = scanner.next();
        Stack<Character> openBrackets = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (isOpenBracket(line.charAt(i)))
                openBrackets.push(line.charAt(i));

            else if (line.charAt(i) == ' ')
                continue;

            else
                if (leftBrackets.indexOf(openBrackets.pop()) != rightBrackets.indexOf(line.charAt(i))) {
                    System.out.println(line.charAt(i) + " " + i);
                    return;
                }
        }
        System.out.println("ok so far");
    }
    private static boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }
}
