import java.util.ArrayList;

class Node {
    int src;
    int dest;
    int wt;

    Node(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}

public class Graph {

    public static void main(String[] args) {

        int v = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Node>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Node(0, 1, 5));
        graph[0].add(new Node(0, 3, 5));

        graph[1].add(new Node(1, 0, 5));
        graph[1].add(new Node(1, 2, 5));

        graph[2].add(new Node(2, 1, 5));
        graph[2].add(new Node(2, 4, 5));

        graph[3].add(new Node(3, 4, 5));
        graph[3].add(new Node(3, 0, 5));

        graph[4].add(new Node(4, 3, 5));
        graph[4].add(new Node(4, 2, 5));
    }
}