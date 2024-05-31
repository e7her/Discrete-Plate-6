package DiscretePlate6;

import java.util.*;

public class IncidenceMatrixGraph {

    public static int[][] createIncidenceMatrix(int n, List<int[]> edges) {
        int edgeCount = edges.size();
        int[][] incidenceMatrix = new int[n][edgeCount];

        for (int i = 0; i < edgeCount; i++) {
            int[] edge = edges.get(i);
            int u = edge[0];
            int v = edge[1];
            incidenceMatrix[u][i]++;
            if (u != v) { // Ensures self-loops are only incremented once
                incidenceMatrix[v][i]++;
            }
        }

        return incidenceMatrix;
    }

    public static void printIncidenceMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int e = scanner.nextInt();

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            System.out.print("Enter vertex pair (u, v) and number of times edge appears (u v times): ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int times = scanner.nextInt();
            for (int j = 0; j < times; j++) {
                edges.add(new int[]{u, v});
            }
        }

        int[][] incidenceMatrix = createIncidenceMatrix(n, edges);
        System.out.println("Incidence Matrix:");
        printIncidenceMatrix(incidenceMatrix);
    }
}

