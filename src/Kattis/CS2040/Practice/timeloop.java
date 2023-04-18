package Kattis.CS2040.Practice;

import java.util.Scanner;

public class timeloop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short loop = scanner.nextShort();
        for (int i = 1; i <= loop; i++) {
            String line = i + " Abracadabra ";
            System.out.println(line);
        }
    }
}
