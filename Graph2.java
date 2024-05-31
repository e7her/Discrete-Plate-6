package DiscretePlate6;

import java.util.ArrayList;

class storeVertex {
    ArrayList<ArrayList<Integer>> graph; // list of lists
    int V;

    storeVertex(int nodesPlusOne){
        V = nodesPlusOne;
        graph = new ArrayList<ArrayList<Integer>>(); // outer list
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer>()); // empty list for each vertex
        }
    }

    void addEdge(int v, int u){
        graph.get(v).add(u); // add u to v's list
        graph.get(u).add(v); // add v to u's list (Simple graph: Undirected edges)
    }

    void printGraph(){
        for (int i = 1; i < V; i++) {
            System.out.print("Node " + i + ":");
            for (int x : graph.get(i)) System.out.print(" <---> " + x);
            System.out.println();
        }
    }



    // DFS ALGORITHM APPLICATION:
    boolean isConnected() {
        boolean[] visited = new boolean[V];  // initializes the visited vertex array

        dfsTraversal(1, visited); //start exploring the graph from the first node

        for (int i = 1; i < V; i++) {
            if (!visited[i]) {
                return false;  //if it returns false, theres an unvisited vertex = unconnected
            }
        }
        return true; //true = connected
    }

    void dfsTraversal(int node, boolean[] visited) {        //Performs the DFS
        visited[node] = true; // mark current node as visited
        for (int neighbor : graph.get(node)) {  //search for its adjacent vertices through u and v linkedlist
            if (!visited[neighbor]) {
                dfsTraversal(neighbor, visited); //recusively call the method to explore it further
            }
        }
    }

    int countConnectedComponents() {
        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 1; i < V; i++) {
            if (!visited[i]) {
                dfsTraversal(i, visited);
                count++;
            }
        }
        return count;
    }
}

public class Graph2 {
    public static void main(String[] args){
        storeVertex g = new storeVertex(9); // existing nodes in the graph + 1

        // INPUT EDGES OF THE GRAPH HERE:

        g.addEdge(1, 2 );
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(7,  8);
        g.addEdge(8, 5);
        g.printGraph();

        if (g.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + g.countConnectedComponents());
        }
    }
}
