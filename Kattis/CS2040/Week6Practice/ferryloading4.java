package Kattis.CS2040.Week6Practice;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ferryloading4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            Ferry ferry = new Ferry(scanner.nextInt());

            int cars = scanner.nextInt();
            for (int j = 0; j < cars; j++) {
                int car = scanner.nextInt();
                String location = scanner.next();
                if ((ferry.isLeft() && location.equals("left")) || (!ferry.isLeft() && location.equals("right"))) {
                    ferry.addCar(car);
                }
                else {
                    ferry.crossRiver();
                    ferry.addCar(car);
                }
                if (j == cars - 1 && ferry.loadLength != 0)
                    ferry.crossRiver();
            }
            System.out.println(ferry.crossCount);
        }
    }

    private static class Ferry {
        private int length;
        private int loadLength = 0;
        private int crossCount = 0;
        private boolean isLeft = true;
        private Queue<Integer> ferry = new ArrayDeque<>();

        public Ferry(int length) {
            this.length = length * 100;
        }

        public void addCar(int carLength) {
            if (loadLength + carLength >= length) {
                crossRiver();
                crossRiver();
            }
            loadLength += carLength;
        }

        public void crossRiver() {
            crossCount++;
            isLeft = !isLeft;
            removeLoad();
        }

        private void removeLoad() {
            loadLength = 0;
        }

        public boolean isLeft() {
            return isLeft;
        }
    }
}
