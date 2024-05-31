package DiscretePlate6;
import java.util.*;

public class graphAdj {

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

        // Map to store edge counts
        Map<String, Integer> edgeCount = new HashMap<>();

        // Process the adjacency matrix to list edges and count their occurrences
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] > 0) {
                    String edge = "(" + i + ", " + j + ")";
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + adjMatrix[i][j]);
                }
            }
        }

        // Output the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println(entry.getKey() + " appears " + entry.getValue() + " times");
        }

        scanner.close();
    }
}
