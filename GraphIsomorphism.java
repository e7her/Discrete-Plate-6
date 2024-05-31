package DiscretePlate6;

import java.util.*;

public class GraphIsomorphism {

    public static boolean areIsomorphic(int n, List<int[]> edges1, List<int[]> edges2) {
        // If the number of edges is not the same, the graphs cannot be isomorphic
        if (edges1.size() != edges2.size()) {
            return false;
        }

        // Create adjacency matrices for both graphs
        int[][] adjMatrix1 = createAdjacencyMatrix(n, edges1);
        int[][] adjMatrix2 = createAdjacencyMatrix(n, edges2);

        // Utilize a utility function to check for isomorphism
        return areIsomorphicUtil(adjMatrix1, adjMatrix2, new boolean[n], new int[n], 0);
    }

    private static boolean areIsomorphicUtil(int[][] adjMatrix1, int[][] adjMatrix2, boolean[] visited, int[] mapping, int vertex) {
        int n = adjMatrix1.length;

        if (vertex == n) {
            // Check if the mapping maintains the same adjacency relationships
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adjMatrix1[i][j] != adjMatrix2[mapping[i]][mapping[j]]) {
                        return false;
                    }
                }
            }
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                mapping[vertex] = i;

                if (areIsomorphicUtil(adjMatrix1, adjMatrix2, visited, mapping, vertex + 1)) {
                    return true;
                }

                visited[i] = false;
            }
        }

        return false;
    }

    private static int[][] createAdjacencyMatrix(int n, List<int[]> edges) {
        int[][] adjMatrix = new int[n][n];
        for (int[] edge : edges) {
            if (edge[0] < n && edge[1] < n) {
                adjMatrix[edge[0]][edge[1]] = 1;
                adjMatrix[edge[1]][edge[0]] = 1;
            } else {
                throw new IllegalArgumentException("Edge references vertices outside the valid range");
            }
        }
        return adjMatrix;
    }

    public static void main(String[] args) {
        List<int[]> edges1, edges2;

        // Test Case 1
        edges1 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0});
        edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0});
        System.out.println("Test Case 1: " + areIsomorphic(3, edges1, edges2)); // true

        // Test Case 2
        edges1 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0});
        edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4});
        System.out.println("Test Case 2: " + areIsomorphic(5, edges1, edges2)); // false

        // Test Case 3
        edges1 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}, new int[]{0, 2});
        edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}, new int[]{1, 3});
        System.out.println("Test Case 3: " + areIsomorphic(4, edges1, edges2)); // true

        // Test Case 4
        edges1 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}, new int[]{2, 3});
        edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0});
        System.out.println("Test Case 4: " + areIsomorphic(4, edges1, edges2)); // false

        // Test Case 5
        edges1 = Arrays.asList(new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{2, 3});
        edges2 = Arrays.asList(new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2}, new int[]{2, 3});
        System.out.println("Test Case 5: " + areIsomorphic(4, edges1, edges2)); // false
    }
}
