package ca.qc.vc.week7.lesson20;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class PathExistsBFS {

    /*
     * Determine whether a path exists from source to destination.
     */
    public static boolean validPath(int n, int[][] edges,
                                    int source, int destination) {

        // Build the adjacency list
        List<Integer>[] graph = buildAdjList(n, edges);

        // Queue used by BFS
        Queue<Integer> queue = new ArrayDeque<>();

        // seen[i] indicates whether vertex i has been visited
        boolean[] seen = new boolean[n];

        queue.offer(source);
        seen[source] = true;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            // Destination found
            if (current == destination) {
                return true;
            }

            // Visit all unvisited neighbors
            for (int neighbor : graph[current]) {

                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        // BFS finished without finding the destination
        return false;
    }

    /*
     * Build an adjacency list for an undirected graph.
     */
    @SuppressWarnings("unchecked")
    private static List<Integer>[] buildAdjList(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        // Create an empty adjacency list for every vertex
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Because the graph is undirected, add each edge twice
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        return graph;
    }

    /*
     * Print the adjacency list.
     */
    private static void printGraph(List<Integer>[] graph) {

        System.out.println("Adjacency list:");

        for (int vertex = 0; vertex < graph.length; vertex++) {
            System.out.println(vertex + " -> " + graph[vertex]);
        }
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 0}
        };

        int source = 0;
        int destination = 2;

        // Print the input
        System.out.println("Number of vertices: " + n);
        System.out.println("Edges: " + Arrays.deepToString(edges));
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);

        // Build and display the adjacency list
        List<Integer>[] graph = buildAdjList(n, edges);
        printGraph(graph);

        // Check whether a path exists
        boolean result = validPath(n, edges, source, destination);

        System.out.println(
                "Does a path exist from " + source +
                        " to " + destination + "? " + result
        );
    }
}