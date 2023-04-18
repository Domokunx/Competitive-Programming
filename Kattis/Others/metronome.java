package Kattis.Others;

import java.text.DecimalFormat;
import java.util.Scanner;

public class metronome {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float ticks = scanner.nextFloat();
        float revolutions = ticks / 4;
        System.out.println(df.format(revolutions));
    }
}