package Kattis.CS2040.Week7Practice;

import java.util.Scanner;

public class whatdoesthefoxsay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            String audio = " " + scanner.next();
            String noise = scanner.next();
            while (!noise.equals("what does the fox say?")) {
                String[] noiseArr = noise.split(" ");
                audio = audio.replaceAll(" " + noiseArr[2], "");
                noise = scanner.next();
            }
            System.out.println(audio.replaceFirst(" ", ""));
        }
    }
}
