package Kattis.CS2040.Week4Practice;

import java.awt.*;
import java.util.Scanner;

public class exactlyelectrical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Point start = new Point(scanner.nextInt(), scanner.nextInt());
        Point end = new Point(scanner.nextInt(), scanner.nextInt());
        int battery = scanner.nextInt();
        if (isEmpty(battery)) {
            System.out.println("N");
            return;
        }

        battery = moveToDestination(start, end, battery);
        if (hasReached(start, end) && battery % 2 == 0) {
            System.out.println("Y");
        }
        else {
            System.out.println("N");
        }
    }

    private static int moveToDestination(Point start, Point end, int battery) {
        int horizontal = Math.abs(start.x - end.x);
        int vertical = Math.abs(start.y - end.y);
        while (!hasReached(start, end)) {
            if (horizontal != 0) {
                if (end.x > start.x) {
                    start.x++;
                    horizontal--;
                    battery--;
                }
                else if (end.x < start.x) {
                    start.x--;
                    horizontal--;
                    battery--;
                }
            }
            if (vertical != 0) {
                if (end.y > start.y) {
                    start.y++;
                    vertical--;
                    battery--;
                }
                else if (end.y < start.y) {
                    start.y--;
                    vertical--;
                    battery--;
                }
            }
        }
        return battery;
    }

    private static boolean isEmpty(int battery) {
        return battery <= 0;
    }

    private static boolean hasReached(Point start, Point end) {
        return (start.x == end.x && start.y == end.y);
    }
}
