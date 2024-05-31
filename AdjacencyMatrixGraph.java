package DiscretePlate6;
import java.util.*;

public class AdjacencyMatrixGraph {

    public static int[][] createAdjacencyMatrix(int n, List<int[]> edges, boolean directed) {
        int[][] adjacencyMatrix = new int[n][n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyMatrix[u][v]++;
            if (!directed) {
                adjacencyMatrix[v][u]++;
            }
        }

        return adjacencyMatrix;
    }

    public static void printAdjacencyMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test cases
        List<int[]> edges1 = Arrays.asList(new int[]{0, 1}, new int[]{0, 3}, new int[]{1, 2}, new int[]{2, 3});
        int[][] matrix1 = createAdjacencyMatrix(4, edges1, false);
        System.out.println("Test Case 1:");
        printAdjacencyMatrix(matrix1);

        List<int[]> edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}, new int[]{0, 1});
        int[][] matrix2 = createAdjacencyMatrix(3, edges2, true);
        System.out.println("Test Case 2:");
        printAdjacencyMatrix(matrix2);

        List<int[]> edges3 = Arrays.asList(new int[]{0, 0}, new int[]{0, 2}, new int[]{0, 3}, new int[]{3, 4});
        int[][] matrix3 = createAdjacencyMatrix(5, edges3, false);
        System.out.println("Test Case 3:");
        printAdjacencyMatrix(matrix3);

        List<int[]> edges4 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0});
        int[][] matrix4 = createAdjacencyMatrix(3, edges4, true);

        System.out.println("Test Case 4:");
        printAdjacencyMatrix(matrix4);

        List<int[]> edges5 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0});
        int[][] matrix5 = createAdjacencyMatrix(3, edges5, false);
        System.out.println("Test Case 5:");
        printAdjacencyMatrix(matrix5);
    }
}