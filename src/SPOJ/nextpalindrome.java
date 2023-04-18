package SPOJ;

import java.util.HashMap;
import java.util.Scanner;

public class nextpalindrome {
    public static void main(String[] args) {
        // Write the value of the next palindrome larger than K(input), K < 1_000_000 DIGITS
        // EG:
        // 808 -> 818
        // 2133 -> 2222
        //Testcases
//        40
//        808 (OK)
//        2133 (OK)
//        9999999 (OK)
//        999999 (OK)
//        899998 (800008)
//        3423355356 (OK)
//        100001 (OK)
//        46887767 (OK)
//        9 (OK)
//        99  (OK)
//        0 (OK)
//        1991 (2002
//        1239400
//        123999500
//        56442
//        56471
//        123456
//        1234567
//        77777777777
//        2991
//        3994
//        9999
//        5448
//        653434
//        101
//        199
//        0012100
//        0003
//        123456
//        1234567
//        9999
//        99999
//        1
//        2991
//        3994
//        9999
//        5448
//        65343454
//        100
//        4111
        // i think work from the middle?
        // if left digit < right digit, add one to left and make right = left
        // if left digit > right digit, make right digit  = left
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Character> conversionTable = new HashMap<>();
        conversionTable.put('0', '1');
        conversionTable.put('1', '2');
        conversionTable.put('2', '3');
        conversionTable.put('3', '4');
        conversionTable.put('4', '5');
        conversionTable.put('5', '6');
        conversionTable.put('6', '7');
        conversionTable.put('7', '8');
        conversionTable.put('8', '9');
        conversionTable.put('9', '0');

        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            String K = scanner.next();
            char[] KArray = K.toCharArray();
            boolean isSmaller = false;
            int middleIndex = K.length() / 2;
            int leftPtr = middleIndex - 1;
            int rightPtr = K.length() % 2 == 0 ? middleIndex : middleIndex + 1;

            while (leftPtr >= 0 && KArray[leftPtr] == KArray[rightPtr]) {
                leftPtr--;
                rightPtr++;
            }

            // Case 1: Input is palindrome OR copying left to right results in smaller number
            // Case 1.1: Need to increment middle (set boolean check)
            if (leftPtr < 0 || KArray[leftPtr] < KArray[rightPtr])
                isSmaller = true;

            // Copy Left side to Right Side for remaining
            while (leftPtr >= 0)
                KArray[rightPtr++] = KArray[leftPtr--];

            // Case 1.1: Incrementing middle
            if (isSmaller) {
                char carry = '1';

                // Odd Case
                if (K.length() % 2 != 0) {
                    KArray[middleIndex] = conversionTable.get(KArray[middleIndex]);
                    carry = KArray[middleIndex] == '0' ? '1' : '0';
                }
                // Otherwise proceed like Even Case
                leftPtr = middleIndex - 1;
                rightPtr = K.length() % 2 == 0 ? middleIndex : middleIndex + 1;

                // Bring the carry over to the left and copy to the right
                while (leftPtr >= 0 && carry == '1') {
                    KArray[leftPtr] = conversionTable.get(KArray[leftPtr]);
                    carry = KArray[leftPtr] == '0' ? '1' : '0';
                    KArray[rightPtr++] = KArray[leftPtr--];
                }
            }
            StringBuilder sb = new StringBuilder();
            int zeroCount = 0;
            for (char c : KArray) {
                sb.append(c);
                if (c == '0')
                    zeroCount++;
            }
            if (zeroCount == sb.length()) {
                sb.replace(0, 1, "1");
                sb.append("1");
            }
            System.out.println(sb);
        }
    }
}
