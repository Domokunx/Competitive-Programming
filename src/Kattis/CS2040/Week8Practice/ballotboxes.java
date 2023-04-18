package Kattis.CS2040.Week8Practice;

import java.util.*;

public class ballotboxes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endInput = scanner.nextInt();
        while (endInput != -1) {
            int townCount = endInput;
            int boxes = scanner.nextInt();
            int sum = 0;
            PriorityQueue<Town> towns = new PriorityQueue<>(townCount, new TownComparator());
            for (int i = 0; i < townCount; i++) {
                int population = scanner.nextInt();
                Town town = new Town(population);
                towns.add(town);
                sum += population;
            }
            for (int i = 0; i < towns.size(); i++) {
                if (towns.peek().population <= sum / boxes) {
                    towns.poll();
                    boxes--;
                }
            }
            int maxPerBox = Integer.MAX_VALUE;
            List<Town> townList = towns.stream().toList();
            int spareBoxes = boxes - towns.size();

            // Basically allocate every town a box, give spareBoxes to largest town.
            // If Largest town box still has most ppl/box return that
            // else, give a box to whichever town has a larger ppl/box;
            // recursion ends when no more spareBoxes to give / largest town has largest ppl / box;
            Town largestTown = townList.get(towns.size() - 1);
            largestTown.boxes += spareBoxes;
            for (int i = 0; spareBoxes > 0; i++) {
                int currentMax = largestTown.population / largestTown.boxes;

                for (int j = 0; townList.get(j) != largestTown; j++) {
                    if (townList.get(j).population / townList.get(j).boxes > currentMax) {
                        currentMax = townList.get(j).population / townList.get(j).boxes;
                        largestTown.boxes -= 1;
                        townList.get(j).boxes += 1;
                        spareBoxes--;
                    }
                }
                if (maxPerBox > currentMax) {
                    maxPerBox = currentMax;
                }
                else break;
            }
            System.out.println(maxPerBox);
            endInput = scanner.nextInt();
        }
    }
    static class TownComparator implements Comparator<Town> {
        @Override
        public int compare(Town o1, Town o2) {
            if (o1.population > o2.population)
                return 1;
            else if (o1.population < o2.population)
                return -1;
            return 0;
        }
    }

    private static class Town {
        private int boxes = 1;
        private int population;

        public Town(int population) {
            this.population = population;
        }
    }
}
