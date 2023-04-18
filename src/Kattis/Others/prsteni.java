package Kattis.Others;

import java.util.Scanner;

public class prsteni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rings = scanner.nextInt();
        int firstRingRad = scanner.nextInt();

        for (int i = 0; i < rings - 1; i++) {
            int subRingRad = firstRingRad;
            int ringRad = scanner.nextInt();
            while (subRingRad % 2 == 0 && ringRad % 2 == 0) {
                subRingRad /= 2;
                ringRad /= 2;
            }
            while (subRingRad % 3 == 0 && ringRad % 3 == 0) {
                subRingRad /= 3;
                ringRad /= 3;
            }
            while (subRingRad % 5 == 0 && ringRad % 5 == 0) {
                subRingRad /= 5;
                ringRad /= 5;
            }
            double turns = (double) subRingRad / ringRad;
            for (int j = 1; j <= ringRad; j++) {
                if ((turns * j) % 1 == 0) {
                    System.out.println((int) (turns * j) + "/" + j);
                    break;
                }
                else if (j == ringRad)
                    System.out.println(subRingRad + "/" + ringRad);
            };
        }
    }
}
