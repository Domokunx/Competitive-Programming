package Kattis.Others;

import java.util.Scanner;

public class skruop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        int requests = scanner.nextInt();
        int volume = 7;
        for (int i = 0; i < requests; i++){
            String command = scanner.next();
            if (command.equals("Skru op!") && volume != 10)
                volume++;
            else if (command.equals("Skru ned!") && volume != 0)
                volume--;
        }
        System.out.println(volume);
    }
}