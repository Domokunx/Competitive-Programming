package Kattis.CS2040.Week6Practice;

import java.util.*;

public class integerlists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter(",|\\n");

        short testcases = scanner.nextShort();
        for (int i = 0; i < testcases; i++) {
            String commands = scanner.next();
            int elementCount = scanner.nextInt();
            Queue<Integer> elements = new ArrayDeque<>(elementCount);
            for (int j = 0; j < elementCount; j++) {
                String element = scanner.next();
                element = element.replaceAll("\\[|\\]", "");
                elements.add(Integer.parseInt(element));
            }

            boolean success = true;
            for (char command : commands.toCharArray()) {
                success = BAPC(command, elements);
                if (!success) {
                    break;
                }
            }
            System.out.println(!success ? "error" : elements);
        }

    }

    private static boolean BAPC(char command, Queue<Integer> elements) {
        if (command == 'R') {
            Stack<Integer> stack = new Stack<>();
            while (!elements.isEmpty())
                stack.push(elements.remove());
            for (int i = 0; !stack.isEmpty(); i++) {
                elements.add(stack.pop());
            }
        }

        if (command == 'D') {
            if (elements.isEmpty()) {
                return false;
            }
            elements.remove();
        }
        return true;
    }
}
