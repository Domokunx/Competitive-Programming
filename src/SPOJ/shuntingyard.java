package SPOJ;

import java.util.*;

public class shuntingyard {
    public static void main(String[] args) {
        // Takes an arithmetic expression (infix notation) and returns Reverser Polish Notation (postfix notation)
        // Requires : output queue , operator stack
        // Precedence Table :
        // Symbol : Precedence : Value
        // ^      : High       : 3
        // /      : Mid        : 2
        // *      : Mid        : 2
        // +      : Low        : 1
        // -      : Low        : 1

        // Example Conversions:
        // "5 + 8" -> "5 8 +"
        // "A + B - C * D + (E ^ F) * G / H + I" -> "A B + C D * - E F ^ G * H / + I +
        // "4 + 2 / (9 - 8) ^ 4 ^ 2" -> "4 2 9 8 - 4 2 ^ ^ / +"
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> precedenceTable = new HashMap<Character, Integer>();
        precedenceTable.put('^', 3);
        precedenceTable.put('*', 2);
        precedenceTable.put('/', 2);
        precedenceTable.put('+', 1);
        precedenceTable.put('-', 1);

        int expressionCount = scanner.nextInt();
        for (int i = 0; i < expressionCount; i++) {
            Stack<Character> operators = new Stack<>();
            Queue<Character> output = new ArrayDeque<>();
            String input = scanner.next();
            for (char c : input.toCharArray()) {
                if (c >= 97 && c <= 122)
                    output.add(c);
                else {
                    if (c == '(') {
                        operators.add(c);
                        continue;
                    }
                    if (c == ')') {
                        while (operators.peek() != '(')
                            output.add(operators.pop());
                        operators.pop();
                        continue;
                    }
                    if (operators.isEmpty() || operators.peek() == '(')
                        operators.add(c);
                    else {
                        while (precedenceTable.get(operators.peek()) > precedenceTable.get(c)) {
                            output.add(operators.pop());
                        }
                        operators.add(c);
                    }
                }
            }
            while (!operators.isEmpty())
                output.add(operators.pop());
            StringBuilder sb = new StringBuilder();
            while (!output.isEmpty())
                sb.append(output.remove());
            System.out.println(sb);
        }
    }
}
