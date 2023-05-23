package LeetCode;

import java.util.*;

public class evaluateDivision {
    public static void main(String[] args) {
        List<List<String>> e = new ArrayList<List<String>>();
        List<List<String>> q = new ArrayList<List<String>>();

        e.add(List.of(new String[]{"x1", "x2"}));
        e.add(List.of(new String[]{"x2", "x3"}));
        e.add(List.of(new String[]{"x3", "x4"}));
        e.add(List.of(new String[]{"x4", "x5"}));

        double[] d = {3.0,4.0,5.0,6.0};

        q.add(List.of(new String[]{"x5", "x2"}));
        System.out.println(Arrays.toString(calcEquation(e,d,q)));
    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = convertToGraph(equations, values);
        double[] result = new double[queries.size()];

        int i = 0;
        for (List<String> query : queries) {
            if (query.get(0).equals(query.get(1)) && graph.get(query.get(0)) != null) {
                result[i++] = 1.0;
                continue;
            }
            if (!DFS(graph, query.get(0), query.get(1)))
                result[i++] = -1.0;
            else {
                result[i++] = calcValue(graph, query.get(0), query.get(1)); // Add Calc function later
            }
        }

        return result;
    }

    private static HashMap<String, HashMap<String, Double>> convertToGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);

            graph.putIfAbsent(numerator, new HashMap<String, Double>());
            graph.get(numerator).putIfAbsent(denominator, values[i]);

            graph.putIfAbsent(denominator, new HashMap<String, Double>());
            graph.get(denominator).putIfAbsent(numerator, 1.0 / values[i]);
        }
        return graph;
    }

    private static boolean DFS(HashMap<String, HashMap<String, Double>> graph, String start, String end) {
        HashSet<String> visited = new HashSet<>();
        return DFS(graph, start, end, visited);
    }
    private static boolean DFS(HashMap<String, HashMap<String, Double>> graph, String start, String end, HashSet<String> visited) {
        visited.add(start);

        HashMap<String, Double> edges = graph.get(start);
        if (edges == null) return false;
        for (String denominator : edges.keySet()) {
            if (visited.contains(denominator)) continue;

            if (denominator.equals(end)) return true;

            // if (graph.get(denominator).get(end) != null) return true;

            if (DFS(graph, denominator, end, visited)) return true;
        }
        return false;
    }

    private static double calcValue(HashMap<String, HashMap<String, Double>> graph, String start, String end) {
        HashSet<String> visited = new HashSet<>();
        return calcValue(graph, start, end, visited);
    }
    private static double calcValue(HashMap<String, HashMap<String, Double>> graph, String start, String end, HashSet<String> visited) {
        if (visited.contains(start)) return 1;
        visited.add(start);

        HashMap<String, Double> edges = graph.get(start);
        // Direct Path Case
        if (edges.get(end) != null) return edges.get(end);

        // Indirect Path Case
        double result = 1;
        for (String denominator : edges.keySet()) {
            if (visited.contains(denominator)) continue;
            result = edges.get(denominator);
            System.out.println(denominator);
            if (graph.get(denominator).size() == 1) continue; // Returns to itself

            if (DFS(graph, denominator, end))
                result *= (calcValue(graph, denominator, end, visited));
        }

        return result;
    }
}
