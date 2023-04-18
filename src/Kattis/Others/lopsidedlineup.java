package Kattis.Others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class lopsidedlineup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short players = scanner.nextShort();
        int[][] scores = new int[players][players];
        int[] highTeam = new int[players / 2];
        int[] lowTeam = new int[players / 2];
        int highestPairScore = 0;
        int lowestPairScore = Integer.MAX_VALUE;
        int[] bestPair = new int[2];
        int[] worstPair = new int[2];

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < players; j++) {
                int currentScore = scanner.nextInt();
                scores[i][j] = currentScore;

                if (currentScore > highestPairScore) {
                    highestPairScore = currentScore;
                    if  (!Arrays.asList(worstPair).contains(i) || !Arrays.asList(worstPair).contains(j)){
                        bestPair = new int[]{i, j};
                    }
                }
                
                if (currentScore < lowestPairScore) {
                    lowestPairScore = currentScore;
                    if (!Arrays.asList(bestPair).contains(i) || !Arrays.asList(bestPair).contains(j)) {
                        worstPair = new int[]{i, j};
                    }
                }
            }
        }
        
        for (int[] player : scores) {
            System.out.println(Arrays.toString(player));
        }

        System.out.println(Arrays.toString(bestPair));
        System.out.println(Arrays.toString(worstPair));
    }
}

//4
//        0 1 2 2
//        1 0 8 -3
//        2 8 0 5
//        2 -3 5 0
