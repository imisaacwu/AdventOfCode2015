import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lib.FileIO;
import lib.Graph;

public class day09 {
    public static void main(String[] args) {
        List<String> input = FileIO.read("input/day09.in");
        Graph<String> g = new Graph<>();

        for (String[] s : input.stream().map(s -> s.split(" ")).toArray(String[][]::new)) {
            g.addEdge(s[0], s[2], Long.parseLong(s[4]));
            g.addEdge(s[2], s[0], Long.parseLong(s[4]));
        }

        List<String> nodes = g.nodes.keySet().stream().collect(Collectors.toList());

        System.out.println("Day 09:");
        System.out.printf("Part 1: %d\n", exploreMin(g, nodes, 0, Long.MAX_VALUE));
        System.out.printf("Part 2: %d\n", exploreMax(g, nodes, 0, 0));
    }

    static long exploreMin(Graph<String> g, List<String> nodes, int k, long min) {
        for (int i = k; i < nodes.size(); i++) {
            Collections.swap(nodes, i, k);
            min = Math.min(min, exploreMin(g, nodes, k + 1, min));
            Collections.swap(nodes, k, i);
        }
        if (k == nodes.size() - 1) {
            min = Math.min(min, calcPath(g, nodes));
        }
        return min;
    }

    static long exploreMax(Graph<String> g, List<String> nodes, int k, long max) {
        for (int i = k; i < nodes.size(); i++) {
            Collections.swap(nodes, i, k);
            max = Math.max(max, exploreMax(g, nodes, k + 1, max));
            Collections.swap(nodes, k, i);
        }
        if (k == nodes.size() - 1) {
            max = Math.max(max, calcPath(g, nodes));
        }
        return max;
    }

    static long calcPath(Graph<String> g, List<String> path) {
        long cost = 0;
        for (int i = 1; i < path.size(); i++) {
            if (!g.hasEdge(path.get(i-1), path.get(i))) { return Long.MAX_VALUE; }
            cost += g.getWeight(path.get(i-1), path.get(i));
        }
        return cost;
    }
}