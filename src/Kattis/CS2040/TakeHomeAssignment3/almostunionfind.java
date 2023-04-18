package Kattis.CS2040.TakeHomeAssignment3;

import java.util.*;

public class almostunionfind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.next();
        while (!line.equals("")) {
            int setCount = Integer.parseInt(line);
            // Initialise sets
            ArrayList<HashSet<Integer>> sets = new ArrayList<>(setCount);
            for (int i = 0; i < setCount; i++) {
                HashSet<Integer> set = new HashSet<>();
                set.add(i + 1);
                sets.add(set);
            }
            // HashTable to log where the element is currently (Key: element -> Value: setIndex)
            Hashtable<Integer, Integer> elementTable = new Hashtable<>(setCount);
            for (int i = 0; i < setCount; i++) {
                elementTable.put(i + 1, i);
            }
            int commandCount = scanner.nextInt();
            for (int i = 0; i < commandCount; i++) {
                int command = scanner.nextInt();
                switch (command) {
                    case 1 -> {
                        int elementP = scanner.nextInt();
                        int elementQ = scanner.nextInt();
                        unionPQ(elementP, elementQ, sets, elementTable);
                    }
                    case 2 -> {
                        int elementP = scanner.nextInt();
                        int setContainingQIndex = scanner.nextInt();
                        movePToQ(elementP, setContainingQIndex, sets, elementTable);
                    }
                    case 3 -> {
                        int elementP = scanner.nextInt();
                        showSetContainingP(elementP, sets, elementTable);
                    }
                }
            }
            line = scanner.nextLine();
        }
    }

    private static void showSetContainingP(int P, ArrayList<HashSet<Integer>> sets, Hashtable<Integer, Integer> elementTable) {
        // Find set with elementP
        int setWithPIndex = elementTable.get(P);
        HashSet<Integer> setWithP = sets.get(setWithPIndex);

        int sum = 0;
        // print no. of elements && sum of elements
        for (Integer element : setWithP) {
            sum += element;
        }
        System.out.println(setWithP.size() + " " + sum);

    }

    private static void movePToQ(int P, int Q, ArrayList<HashSet<Integer>> sets, Hashtable<Integer, Integer> elementTable) {
        // Find the set containing element;
        int setWithPIndex = elementTable.get(P);
        HashSet<Integer> setWithP = sets.get(setWithPIndex);
        int setWithQIndex = elementTable.get(Q);
        HashSet<Integer> setWithQ = sets.get(setWithQIndex);

        // Update hashtable to give the correct setIndex (since elementP has moved to set with elementQ)
        elementTable.put(P, setWithQIndex);

        // Update the sets (Move 1 element Case)
        setWithQ.add(P);
        setWithP.remove(P);
    }

    private static void unionPQ(int P, int Q, ArrayList<HashSet<Integer>> sets, Hashtable<Integer, Integer> elementTable) {
        // Find the set containing element;
        int setWithPIndex = elementTable.get(P);
        HashSet<Integer> setWithP = sets.get(setWithPIndex);
        int setWithQIndex = elementTable.get(Q);
        HashSet<Integer> setWithQ = sets.get(setWithQIndex);

        // Update hashtable to give the correct setIndex (since elementP has moved to set with elementQ)
        for (Integer element : setWithP) {
            elementTable.put(element, setWithQIndex);
        }

        // Update the sets (Union Case)
        setWithQ.addAll(setWithP);
        setWithP.clear();
    }
}
