package DiscretePlate6;
import java.util.*;

public class VertexDegree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        // Input the number of edges
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();

        // Initialize degree array
        int[] degrees = new int[n];

        // Input the edges
        System.out.println("Enter the edges (pair of vertices):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            degrees[u]++;
            degrees[v]++;
        }

        // Output the degree of each vertex
        System.out.println("Degrees of vertices:");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + " has degree " + degrees[i]);
        }

        scanner.close();
    }
}
