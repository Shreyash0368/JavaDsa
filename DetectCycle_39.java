import java.util.*;

public class DetectCycle_39 {
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

    public static void createGraphUndirected(ArrayList<Edge> graph[]) {
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
        // graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 1, 1));

        // 4
        // graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[4].add(new Edge(4, 2, 1));

        // 5
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 3, 1));

        // 6
        graph[6].add(new Edge(6, 5, 1));

        // 7
        graph[7].add(new Edge(7, 8, 1));
        // graph[7].add(new Edge(7, 9, 1));

        // 8
        graph[8].add(new Edge(8, 7, 1));
        graph[8].add(new Edge(8, 9, 1));

        // 9
        // graph[9].add(new Edge(9, 7, 1));
        graph[9].add(new Edge(9, 8, 1));
        graph[9].add(new Edge(9, 10, 1));

        // 10
        graph[10].add(new Edge(10, 9, 1));
    }

    public static void createGraphDirected(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        // 1
        graph[1].add(new Edge(1, 0, 1));

        // 2
        graph[2].add(new Edge(2, 3, 1));

        // 3
        graph[3].add(new Edge(3, 0, 1));
    }

    public static void BFS(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                BFSUtil(graph, visited, i);
            }
        }
        System.out.println();
    }

    private static void BFSUtil(ArrayList<Edge>[] graph, boolean visited[], int curr) {
        if (visited[curr]) {
            return;
        }
        Queue<Integer> q = new LinkedList<>();

        q.add(curr);
        visited[curr] = true;

        while (q.isEmpty() == false) {
            curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (visited[e.dest] == false) {
                    q.add(e.dest);
                    visited[e.dest] = true;
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                DFSUtil(graph, i, visited);
            }
        }
        System.out.println();

    }

    private static void DFSUtil(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        if (visited[curr] == true) {
            return;
        }

        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[e.dest] == false) {
                DFSUtil(graph, e.dest, visited);
            }
        }

    }

    public static boolean detectCycleUndirected(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                if (detectCycleUndirectedUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean detectCycleUndirectedUtil(ArrayList<Edge> graph[], boolean visited[], int curr, int parent) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (visited[e.dest] && e.dest != parent) {
                return true;
            } else if (visited[e.dest] == false) {
                detectCycleUndirectedUtil(graph, visited, e.dest, curr);
            }
            // else if (visited[e.dest] && e.dest == parent) then do nothing
        }

        return false;
    }

    public static boolean detectCycleDirected(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                if (detectCycleDirectedUtil(graph, visited, stack, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean detectCycleDirectedUtil(ArrayList<Edge> graph[], boolean visited[], boolean stack[],
            int curr) {
        visited[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (visited[e.dest] == false) {
                detectCycleDirectedUtil(graph, visited, stack, e.dest);
            } else if (stack[e.dest]) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v1 = 11;
        ArrayList<Edge> graph1[] = (ArrayList<Edge>[]) new ArrayList[v1];

        createGraphUndirected(graph1);
        BFS(graph1);
        DFS(graph1);
        System.out.println(detectCycleUndirected(graph1));

        int v2 = 4;
        ArrayList<Edge> graph2[] = (ArrayList<Edge>[]) new ArrayList[v2];
        createGraphDirected(graph2);
        BFS(graph2);
        DFS(graph2);
        System.out.println(detectCycleDirected(graph2));
    }

}
