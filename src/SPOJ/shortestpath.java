package SPOJ;

import java.util.*;

public class shortestpath {
    public static void main(String[] args) {
        // Basically dijkstra
        Scanner scanner = new Scanner(System.in);

        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            int cityCount = scanner.nextInt();
            Graph town = new Graph(cityCount);
            for (int j = 1; j <= cityCount; j++) {
                String cityName = scanner.next();
                town.addCity(cityName, j);

                int edgeCount = scanner.nextInt();
                for (int k = 1; k <= edgeCount; k++) {
                    town.addEdge(j, scanner.nextInt(), scanner.nextInt());
                }
            }
            town.print();
            int outputCount = scanner.nextInt();
            for (int j = 0; j < outputCount; j++) {
                System.out.println(town.shortestPathBetween(scanner.next(), scanner.next()));
            }
        }
    }

    private static class Graph {
        private static class City {
            private final String name;
            private final int id;
            private final ArrayList<Edge> edges = new ArrayList<Edge>();

            public City(String name, int id) {
                this.name = name;
                this.id = id;
            }

            public void addEdge(int to, int cost) {
                edges.add(new Edge(id, to, cost));
            }

            public ArrayList<Edge> getEdges() {
                return edges;
            }

            public String getName() {
                return name;
            }
            @Override
            public String toString() {
                return name;
            }
        }

        private record Edge(int fromCity, int toCity, int cost) {

            @Override
                    public String toString() {
                        return "{" + fromCity + "<->" + toCity + ", Cost:" + cost + "}";
                    }
                }

        private final City[] cities;
        private final HashMap<String, Integer> cityIDs;

        public Graph(int cityCount) {
            cities = new City[cityCount];
            cityIDs = new HashMap<String, Integer>(cityCount);
        }

        public void addCity(String name, int cityID) {
            cities[cityID - 1] = new City(name, cityID - 1);
            cityIDs.put(name, cityID - 1);
        }

        public void addEdge(int fromCityID, int toCityID, int cost) {
            City city = cities[fromCityID - 1];
            city.addEdge(toCityID - 1, cost);
        }

        // Dijkstra
        public int shortestPathBetween(String fromCityName, String toCityName) {
            City fromCity = cities[cityIDs.get(fromCityName)];
            City toCity = cities[cityIDs.get(toCityName)];
            
            HashSet<Integer> visited = new HashSet<>();
            PriorityQueue<Edge> queue = new PriorityQueue<>(
                    Comparator.comparingInt(ec -> ec.cost)
            );
            HashMap<Integer, Integer> lowestCost = new HashMap<>();
            for (City city : cities)
                lowestCost.putIfAbsent(city.id, Integer.MAX_VALUE);
            queue.addAll(fromCity.getEdges());
            visited.add(fromCity.id);
            lowestCost.put(fromCity.id, 0);

            while (!queue.isEmpty()) {
                Edge currentEdge = queue.remove();
                int visitingCityID = currentEdge.toCity;
                visited.add(visitingCityID);

                int newDistance = lowestCost.get(currentEdge.fromCity) + currentEdge.cost;
                if (cities[visitingCityID].getName().equals(toCityName))
                    return newDistance;
                if (newDistance < lowestCost.get(currentEdge.toCity)) {
                    lowestCost.put(currentEdge.toCity, newDistance);
                }

                for (Edge e : cities[visitingCityID].getEdges())
                    if (!visited.contains(e.toCity))
                        queue.add(e);
            }
            return lowestCost.get(toCity.id);
        }
        public void print() {
            for (City city : cities) {
                System.out.println(city.getName() + " has connections" + city.getEdges());
            }
        }
    }
}
