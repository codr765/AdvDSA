import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

    static void printGraph(ArrayList<Integer>[] graph, int v) {

        for (int i = 0; i < v; i++) {

            System.out.print(i + " -> ");

            for (int neighbour : graph[i]) {
                System.out.print(neighbour + " ");
            }

            System.out.println();
        }
    }

    static void bfs(ArrayList<Integer>[] graph, int start, int v) {

        boolean[] visited = new boolean[v];

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int curr = q.remove();

            System.out.print(curr + " ");

            for (int neighbour : graph[curr]) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }

    static void dfs(ArrayList<Integer>[] graph, int curr, boolean[] visited) {

        System.out.print(curr + " ");

        visited[curr] = true;

        for (int neighbour : graph[curr]) {

            if (!visited[neighbour]) {
                dfs(graph, neighbour, visited);
            }
        }
    }

    static boolean hasPath(ArrayList<Integer>[] graph, int src, int dest, boolean[] visited) {

        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (int neighbour : graph[src]) {

            if (!visited[neighbour]) {

                if (hasPath(graph, neighbour, dest, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int v = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(1);
        graph[0].add(2);

        graph[1].add(0);
        graph[1].add(3);

        graph[2].add(0);
        graph[2].add(3);
        graph[2].add(4);

        graph[3].add(1);
        graph[3].add(2);

        graph[4].add(2);

        printGraph(graph, v);

        bfs(graph, 0, v);
    }
}