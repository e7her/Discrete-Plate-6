package DiscretePlate6;

import java.util.*;

public class BipartiteGraph {

    public static boolean isBipartite(int n, List<int[]> edges) {
        // Create an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Color array to store colors of vertices
        int[] color = new int[n];
        Arrays.fill(color, -1);

        // Try to color each component
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfsCheck(List<List<Integer>> graph, int src, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        color[src] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases
        List<int[]> edges1 = Arrays.asList(new int[]{0, 1}, new int[]{0, 3}, new int[]{1, 2}, new int[]{2, 3});
        System.out.println(isBipartite(4, edges1)); // true

        List<int[]> edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0});
        System.out.println(isBipartite(3, edges2)); // false

        List<int[]> edges3 = Arrays.asList(new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{3, 4});
        System.out.println(isBipartite(5, edges3)); // true

        List<int[]> edges4 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 0});
        System.out.println(isBipartite(5, edges4)); // false

        List<int[]> edges5 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4});
        System.out.println(isBipartite(5, edges5)); // true
    }
}
