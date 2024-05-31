package DiscretePlate6;
import java.util.Scanner;

public class GraphCycle3 {

    private static boolean hasCycle(int[][] graph, int v, boolean[] visited, int parent) {
        visited[v] = true;

        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] != 0) {
                if (!visited[i]) {
                    if (hasCycle(graph, i, visited, v)) {
                        return true;
                    }
                } else if (i != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCyclic(int[][] graph) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        // Input the adjacency matrix
        int[][] adjMatrix = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        // Check if the graph has a cycle
        if (isCyclic(adjMatrix)) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }

        scanner.close();
    }
}