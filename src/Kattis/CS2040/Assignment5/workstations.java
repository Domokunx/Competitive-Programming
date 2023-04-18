package Kattis.CS2040.Assignment5;

import java.util.*;

public class workstations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int researcherCount = scanner.nextInt();
        int lockTimer = scanner.nextInt();
        int unlockCount = 0;
        PriorityQueue<Researcher> researchers = new PriorityQueue<>(new ResearcherComparator());
        for (int i = 0; i < researcherCount; i++) {
            var researcher = new Researcher(scanner.nextInt(), scanner.nextInt());
            researchers.add(researcher);
        }

        ArrayList<Researcher> workstations = new ArrayList<>();
        unlockCount++;
        workstations.add(researchers.poll());
        while (!researchers.isEmpty()) {
            if (workstations.size() > 1)
                workstations.sort(new WorkstationComparator());
            var currentRes = researchers.poll();
            int stationIndex = 0;
            while (stationIndex < workstations.size() && workstations.get(stationIndex).departureTime > currentRes.arrivalTime) {
                stationIndex++;
            }
            if (stationIndex < workstations.size()) {
                if ((workstations.get(stationIndex).departureTime + lockTimer) <= currentRes.arrivalTime) {
                    unlockCount++;
                }
            }
            workstations.add(currentRes);
        }
        System.out.println(unlockCount);
    }

    private static class ResearcherComparator implements Comparator<Researcher> {

        @Override
        public int compare(Researcher o1, Researcher o2) {
            if (o1.arrivalTime > o2.arrivalTime) {
                return 1;
            }
            else if (o1.arrivalTime < o2.arrivalTime) return -1;
            return 0;
        }
    }
    private static class WorkstationComparator implements Comparator<Researcher> {

        @Override
        public int compare(Researcher o1, Researcher o2) {
            if (o1.departureTime > o2.departureTime) {
                return 1;
            }
            else if (o1.departureTime < o2.departureTime) return -1;
            return 0;
        }
    }
    private static class Researcher {
        private int arrivalTime;
        private int duration;
        private int departureTime;

        public Researcher(int arrivalTime, int duration) {
            this.arrivalTime = arrivalTime;
            this.duration = duration;
            this.departureTime = duration + arrivalTime;
        }

        @Override
        public String toString() {
            return Arrays.toString(new int[] {arrivalTime, departureTime});
        }
    }
}
