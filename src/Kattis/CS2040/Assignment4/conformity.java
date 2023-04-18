package Kattis.CS2040.Assignment4;

import java.util.*;

public class conformity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int froshCount = scanner.nextInt();
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < froshCount; i++) {
            int count = 0;
            final int COURSE_COUNT = 5;
            Queue<Integer> coursesQ = new PriorityQueue<>(COURSE_COUNT);
            StringBuilder courses = new StringBuilder();
            for (int j = 0; j < COURSE_COUNT; j++) {
                coursesQ.add(scanner.nextInt());
            }
            while (!coursesQ.isEmpty())
                courses.append(coursesQ.remove());
            hm.put(courses.toString(), hm.containsKey(courses.toString()) ? hm.get(courses.toString()) + 1 : 1);
        }
        int sheepleCount = 0;
        int popularityMAX = Integer.MIN_VALUE;
        for (var e : hm.entrySet()) {
            int popularity = e.getValue();
            if (popularity > popularityMAX) {
                popularityMAX = popularity;
                sheepleCount = 0;
            }

            if (popularity == popularityMAX)
                sheepleCount += popularity;
        }
        System.out.println(sheepleCount);
    }
}
