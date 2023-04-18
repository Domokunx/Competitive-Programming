package Kattis.CS2040.Week5Practice;

import java.util.*;

public class classy {
    private static class Person {
        public Long classLevel;
        public String name;

        public Person(Long classLevel, String name) {
            this.classLevel = classLevel;
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short cases = scanner.nextShort();
        for (short i = 0; i < cases; i++) {
            byte personCount = scanner.nextByte();
            Person[] people = new Person[personCount];
            for (int j = 0; j < personCount; j++) {
                String name = scanner.next();
                String classLevel = scanner.next();
                String theWordClass = scanner.next();

                name = name.replaceAll(":", "");
                classLevel = classLevel.replaceAll("upper","3");
                classLevel = classLevel.replaceAll("middle","2");
                classLevel = classLevel.replaceAll("lower","1");
                classLevel = classLevel.replaceAll("-","");
                while (classLevel.length() != 10) {
                    classLevel = "2" + classLevel;
                }

                Stack<Character> stack = new Stack<>();
                for (int k = 0; k < classLevel.length(); k++) {
                    stack.push(classLevel.charAt(k));
                }
                var sb = new StringBuilder();
                for (int k = 0; k < classLevel.length(); k++) {
                    sb.append(stack.pop());
                }
                people[j] = new Person(Long.parseLong(sb.toString()), name);
            }
            Arrays.sort(people, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o2.classLevel.compareTo(o1.classLevel);
                }
            });
            for (Person p : people) {
                System.out.println(p.name);
            }
            System.out.println("==============================");
        }
    }
}
