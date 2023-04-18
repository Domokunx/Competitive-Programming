package Kattis.CS2040.Assignment3;

import java.util.Scanner;

public class coconut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte syllables = scanner.nextByte();
        byte playerCount = scanner.nextByte();
        byte[] hands = new byte[playerCount * 2];
        // Set up game
        for (int i = 0; i < hands.length; i++) {
            if (i % 2 == 0) {
                hands[i] = 3;
            }
        }

        int currentHandCount = playerCount;
        int handIndex = 0;
        while (true) {
            for (int i = 1; i < syllables; i++) {
                handIndex++;
                if (handIndex == hands.length)
                    handIndex = 0;

                while (hands[handIndex] == 0) {
                    handIndex++;
                    if (handIndex == hands.length)
                        handIndex = 0;
                }
            }

            if (hands[handIndex] == 3) {
                hands[handIndex] = 2;
                hands[handIndex + 1] = 2;
                currentHandCount++;
            }
            else if (hands[handIndex] == 2) {
                hands[handIndex++] = 1;
                if (handIndex == hands.length)
                    handIndex = 0;
                while (hands[handIndex] == 0) {
                    handIndex++;
                    if (handIndex == hands.length)
                        handIndex = 0;
                }
            }
            else if (hands[handIndex] == 1) {
                hands[handIndex++] = 0;
                if (handIndex == hands.length)
                    handIndex = 0;
                while (hands[handIndex] == 0) {
                    handIndex++;
                    if (handIndex == hands.length)
                        handIndex = 0;
                }
                currentHandCount--;
            }
            if (currentHandCount == 1) {
                while (hands[handIndex] == 0) {
                    handIndex++;
                    if (handIndex == hands.length)
                        handIndex = 0;
                }
                System.out.println(handIndex / 2 + 1);
                return;
            }
        }
    }
}
