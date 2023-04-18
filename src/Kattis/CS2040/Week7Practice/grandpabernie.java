package Kattis.CS2040.Week7Practice;

import java.util.*;

public class grandpabernie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tripCount = scanner.nextInt();
        HashMap<String, PriorityQueue<Integer>> tripMap = new HashMap<>();
        for (int i = 0; i < tripCount; i++) {
            String country = scanner.next();
            int year = scanner.nextInt();
            PriorityQueue<Integer> years = new PriorityQueue<>();
            if (tripMap.containsKey(country)) {
                years = tripMap.get(country);
                years.add(year);
                tripMap.put(country, years);
            }
            else {
                years.add(year);
                tripMap.put(country, years);
            }
        }

        int queryCount = scanner.nextInt();
        for (int i = 0; i < queryCount; i++) {
            String country = scanner.next();
            int index = scanner.nextInt();

            System.out.println(tripMap.get(country).toArray()[index - 1]);
        }
    }
}
