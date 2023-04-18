package Kattis.CS2040.TakeHomeAssignment2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class teque {
    private static Deque<Integer> teque = new ArrayDeque<>();
    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandCount = scanner.nextInt();
        for (int i = 0; i < commandCount; i++) {
            String command = scanner.next();
            int value = scanner.nextInt();

            if (command.equals("push_back")) {
                teque.addLast(value);
                count++;
                continue;
            }
            if (command.equals("push_front")) {
                teque.addFirst(value);
                count++;
                continue;
            }
            if (command.equals("push_middle")) {
                push_middle(value);
                count++;
                continue;
            }
            if (command.equals("get")) {
                System.out.println(get(value));
            }
        }
    }

    private static void push_middle(int value) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < (count + 1) / 2; i++) {
            stack.push(teque.pollFirst());
        }

        teque.addFirst(value);
        while (!stack.isEmpty()) {
            teque.addFirst(stack.pop());
        }
    }

    private static int get(int index) {
        Object[] array = teque.toArray();
        return (int)array[index];
    }
}
