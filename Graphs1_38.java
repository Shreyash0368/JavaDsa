import java.util.*;

public class Graphs1_38 {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3
        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 1, 1));

        // 4
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[4].add(new Edge(4, 2, 1));

        // 5
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 3, 1));

        // 6
        graph[6].add(new Edge(6, 5, 1));
    }

    public static void BFS(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (q.isEmpty() == false) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (visited[e.dest] == false) {
                    q.add(e.dest);
                    visited[e.dest] = true;
                }
            }
        }
        System.out.println();
    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        if (visited[curr] == true) {
            return;
        }

        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[e.dest] == false) {
                DFS(graph, e.dest, visited);
            }
        }

    }

    public static boolean hasPath(ArrayList<Edge> graph[], int source, int destination, boolean visited[]) {
        if (source == destination) {
            return true;
        }

        visited[source] = true;

        for (int i = 0; i < graph[source].size(); i++) {
            Edge e = graph[source].get(i);
            if (visited[e.dest] == false && hasPath(graph, e.dest, destination, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[v];

        createGraph(graph);
        BFS(graph);
        DFS(graph, 0, new boolean[graph.length]);
        System.out.println();
        System.out.println(hasPath(graph, 1, 6, new boolean[graph.length]));
    }

}
