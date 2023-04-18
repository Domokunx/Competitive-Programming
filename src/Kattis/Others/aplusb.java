package Kattis.Others;

import java.util.*;

public class aplusb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int elementCount = scanner.nextInt();
        Set<Integer> set = new LinkedHashSet<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int counter = 1;
        for (int i = 0; i < elementCount; i++) {
            int number = scanner.nextInt();
            if (!set.contains(number))
                counter = 1;
            set.add(number);
            countMap.put(number, counter++);
        }

        ArrayList<Integer> elementsList = new ArrayList<>(set);
        int[] elements = elementsList.stream().mapToInt(i -> i).toArray();
        Arrays.sort(elements);
        int ans = 0;
        // set first pointer at back of sorted array as target
        // set 2nd ptr at front of sorted array as firstNum
        // set 3rd ptr at front of sorted as secondNum
        // turns this into a 2SUM question with changing target
        for (int k = elements.length - 1; k >= 0; k--) {
            int i = 0, j = elements.length - 1;
            int currentKCount = countMap.get(elements[k]);
            int target = elements[k];

            while (j >= i) {
                int firstNum = elements[i];
                int secondNum = elements[j];
                int sum = firstNum + secondNum;
                // If less than target, increase sum by increasing firstNum (move ptr right)
                if (sum < target) {
                    i++;
                }
                // If more than target, decrease sum by decreasing secondNum (move ptr left)
                else if (sum > target) {
                    j--;
                }
                // Pair sum == target, find no of possible pair orders
                else {
                    // Special Case: the all is 0 because god damn it can really add to itself
                    if (secondNum == 0 && firstNum == 0 && target == 0 && countMap.get(0) < 3) {
                        break;
                    }
                   // Case 1: all 3 are distinct
                    else if (firstNum != secondNum  && firstNum != target && secondNum != target) {
                        ans += (countMap.get(firstNum) * countMap.get(secondNum)) * 2 * currentKCount;
                    }
                    // Case 2: firstNum == secondNum == target
                    else if (firstNum == secondNum && firstNum == target && countMap.get(firstNum) > 2) {
                        ans += factorial(countMap.get(firstNum));
                    }
                    // Case 3: firstNum == secondNum != target
                    else if (firstNum == secondNum && countMap.get(firstNum) > 1) {
                        ans += factorial(countMap.get(firstNum)) * currentKCount;
                    }
                    // Case 4: firstNum != secondNum == target (firstNum 0)
                    else if (secondNum == target && countMap.get(secondNum) > 1) {
                        ans += factorial(countMap.get(secondNum));
                    }
                    i++;
                    j--;
                }
            }
        }
        System.out.println(ans);
    }

    private static int factorial(int num) {
        if (num == 0) return 1;
        return num * factorial(num - 1);
    }
}
