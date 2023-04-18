//package CodeGoda;
//
//import java.util.Collections;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//public class specialWord {
//
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner scanner = new Scanner(System.in);
//        int testcases = scanner.nextInt();
//        for (int i = 0; i < testcases; i++) {
//            PriorityQueue<Integer> queue = new PriorityQueue<>();
//            String input = scanner.next();
//            while (!input.equals("\"\"")) {
//                if (input.contains("z")) {
//                    input = input.replaceFirst("o", "");
//                    input = input.replaceFirst("z", "");
//                    input = input.replaceFirst("r", "");
//                    input = input.replaceFirst("e", "");
//                    queue.add(0);
//                } else if (input.contains("o") && input.contains("n") && input.contains("e")) {
//                    input = input.replaceFirst("o", "");
//                    input = input.replaceFirst("n", "");
//                    input = input.replaceFirst("e", "");
//                    queue.add(1);
//                } else if (input.contains("w")) {
//                    input = input.replaceFirst("t", "");
//                    input = input.replaceFirst("w", "");
//                    input = input.replaceFirst("o", "");
//                    queue.add(2);
//                } else if (input.contains("t") && input.contains("e") && input.contains("h") && input.contains("r")) {
//                    input = input.replaceFirst("t", "");
//                    input = input.replaceFirst("h", "");
//                    input = input.replaceFirst("r", "");
//                    input = input.replaceFirst("e", "");
//                    input = input.replaceFirst("e", "");
//                    queue.add(3);
//                } else if (input.contains("u")) {
//                    input = input.replaceFirst("f", "");
//                    input = input.replaceFirst("o", "");
//                    input = input.replaceFirst("u", "");
//                    input = input.replaceFirst("r", "");
//                    queue.add(4);
//                } else if (input.contains("f")) {
//                    input = input.replaceFirst("f", "");
//                    input = input.replaceFirst("i", "");
//                    input = input.replaceFirst("v", "");
//                    input = input.replaceFirst("e", "");
//                    queue.add(5);
//                } else if (input.contains("X")) {
//                    input = input.replaceFirst("s", "");
//                    input = input.replaceFirst("i", "");
//                    input = input.replaceFirst("x", "");
//                    queue.add(6);
//                } else if (input.contains("v")) {
//                    input = input.replaceFirst("s", "");
//                    input = input.replaceFirst("e", "");
//                    input = input.replaceFirst("v", "");
//                    input = input.replaceFirst("e", "");
//                    input = input.replaceFirst("n", "");
//                    queue.add(7);
//                } else if (input.contains("t")) {
//                    input = input.replaceFirst("e", "");
//                    input = input.replaceFirst("i", "");
//                    input = input.replaceFirst("g", "");
//                    input = input.replaceFirst("h", "");
//                    input = input.replaceFirst("t", "");
//                    queue.add(8);
//                } else if (input.contains("n")) {
//                    input = input.replaceFirst("n", "");
//                    input = input.replaceFirst("i", "");
//                    input = input.replaceFirst("n", "");
//                    input = input.replaceFirst("e", "");
//                    queue.add(9);
//                }
//            }
//            StringBuilder zeroes = new StringBuilder();
//            for (Integer number : queue) {
//                if (number != 0)
//                    break;
//
//                zeroes.append(number);
//            }
//            queue.removeAll(Collections.singleton(0));
//            StringBuilder sb = new StringBuilder();
//            sb.append(queue.remove());
//            sb.append(zeroes);
//            while (!queue.isEmpty()) {
//                sb.append(queue.remove());
//            }
//            System.out.println(sb);
//        }
//    }
//}