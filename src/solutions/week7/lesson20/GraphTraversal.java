package solutions.week7.lesson20;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {

    static class Graph {
        private final int numberOfVertices;
        private final List<List<Integer>> adjacencyList;

        public Graph(int numberOfVertices) {
            this.numberOfVertices = numberOfVertices;
            adjacencyList = new ArrayList<>();

            for (int i = 0; i < numberOfVertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        // Lab 1: Add an edge to the adjacency list
        public void addEdge(int source, int destination) {
            validateVertex(source);
            validateVertex(destination);

            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        // Lab 1: Print the adjacency list
        public void printAdjacencyList() {
            System.out.println("Adjacency List:");

            for (int vertex = 0; vertex < numberOfVertices; vertex++) {
                System.out.print(vertex + " -> ");

                for (int neighbor : adjacencyList.get(vertex)) {
                    System.out.print(neighbor + " ");
                }

                System.out.println();
            }
        }

        // Lab 2: Depth-First Search
        public void dfs(int startingVertex) {
            validateVertex(startingVertex);

            boolean[] visited = new boolean[numberOfVertices];

            System.out.print("DFS order: ");
            dfsRecursive(startingVertex, visited);
            System.out.println();
        }

        private void dfsRecursive(int vertex, boolean[] visited) {
            visited[vertex] = true;
            System.out.print(vertex + " ");

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    dfsRecursive(neighbor, visited);
                }
            }
        }

        // Lab 3: Breadth-First Search
        public void bfs(int startingVertex) {
            validateVertex(startingVertex);

            boolean[] visited = new boolean[numberOfVertices];
            Queue<Integer> queue = new ArrayDeque<>();

            visited[startingVertex] = true;
            queue.offer(startingVertex);

            System.out.print("BFS order: ");

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");

                for (int neighbor :
                        adjacencyList.get(currentVertex)) {

                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }

            System.out.println();
        }

        private void validateVertex(int vertex) {
            if (vertex < 0 || vertex >= numberOfVertices) {
                throw new IllegalArgumentException(
                        "Invalid vertex: " + vertex
                );
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);

        /*
                       0
                     /   \
                    1     2
                   / \   / \
                  3   4 5   6

            Additional edge: 4 -- 5
        */

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(4, 5);

        // Lab 1
        graph.printAdjacencyList();

        // Lab 2
        graph.dfs(0);

        // Lab 3
        graph.bfs(0);
    }
}