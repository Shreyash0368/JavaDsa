import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BipartiteNTopological_39 {
    static class Edge {
        int src;
        int dest;
        int weight = 1;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }

        public Edge(int s, int d) {
            this(s, d, 1);
        }
    }

    public static void createGraphUndirected(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // 3
        graph[3].add(new Edge(3, 5));
        // graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 1)); // 4
        // graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4, 2));

        // 5
        graph[5].add(new Edge(5, 6));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 3));

        // 6
        graph[6].add(new Edge(6, 5));

        // 2ND component of the graph
        // 7
        graph[7].add(new Edge(7, 8));
        graph[7].add(new Edge(7, 9));

        // 8
        graph[8].add(new Edge(8, 7));
        // graph[8].add(new Edge(8, 9));
        graph[8].add(new Edge(8, 10));

        // 9
        graph[9].add(new Edge(9, 7));
        // graph[9].add(new Edge(9, 8)); graph[9].add(new Edge(9, 10));

        // 10
        graph[10].add(new Edge(10, 9));
        graph[10].add(new Edge(10, 8));
    }

    public static void createGraphDirected(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 // 1

        // 2
        graph[2].add(new Edge(2, 3));

        // 3
        graph[3].add(new Edge(3, 1));

        // 4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static boolean bipartiteGragh(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        // -1 -> unvisited
        // 0 -> red
        // 1 -> blue

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!bipartiteGraghUtil(graph, color, i)) {
                    return false;
                }                        
            }
        }

        return true;
    }

    private static boolean bipartiteGraghUtil(ArrayList<Edge> graph[], int color[], int curr) {
        Queue<Integer> q = new LinkedList<>();
        color[curr] = 0;
        q.add(curr);

        while (!q.isEmpty()) {
            curr = q.remove();
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                if (color[e.dest] == -1) {
                    color[e.dest] = (color[curr] == 0) ? 1 : 0;
                    q.add(e.dest);
                } else if (color[e.dest] == color[curr]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void topologicalSort(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, visited, s, i);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    public static void topologicalSortUtil(ArrayList<Edge> graph[], boolean visited[], Stack<Integer> s, int curr) {
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visited[e.dest]) {
                topologicalSortUtil(graph, visited, s, e.dest);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int v1 = 11;
        ArrayList<Edge> graph1[] = (ArrayList<Edge>[]) new ArrayList[v1];
        System.out.println(bipartiteGragh(graph1));

        
        int v2 = 6;
        ArrayList<Edge> graph2[] = (ArrayList<Edge>[]) new ArrayList[v2];
        createGraphDirected(graph2); 
        
        topologicalSort(graph2);
    }

}
