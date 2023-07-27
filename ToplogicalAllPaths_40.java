import java.util.ArrayList;
import java.util.PriorityQueue;

public class ToplogicalAllPaths_40 {
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

    public static void createGraphDirected(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0
        graph[0].add(new Edge(0, 1, 5));

        // 1
        graph[1].add(new Edge(1, 2, -2));
        graph[1].add(new Edge(1, 5, -3));

        // 2
        graph[2].add(new Edge(2, 4, 3));

        // 3
        graph[3].add(new Edge(3, 2, 6));
        graph[3].add(new Edge(3, 4, -2));

        // 4
        // graph[4].add(new Edge(4, 3, -2));

        // 5
        graph[5].add(new Edge(5, 3, 1));
    }

    public static void toplogicalSortBFS(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        int indegree[] = new int[graph.length];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        // count indegree of all nodes
        for (int i = 0; i < graph.length; i++) {
            int curr = i;
            for (int j = 0; j < graph[curr].size(); j++) {
                Edge e = graph[curr].get(j);
                indegree[e.dest]++;
            }
        }

        // the traversal will start with nodes thathave indegree 0
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            visited[curr] = true;
            System.out.print(curr + " ");
            for (int j = 0; j < graph[curr].size(); j++) {
                // every time we reach a node we remove it from the graph (hence reduce the
                // indegree)
                // and if some new node has indegree 0 we add it
                Edge e = graph[curr].get(j);
                indegree[e.dest]--;
                if (indegree[e.dest] == 0 && !visited[e.dest]) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void allPaths(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPaths(graph, e.dest, dest, path + src);
        }
    }

    public static void main(String[] args) {
        int v2 = 6;
        ArrayList<Edge> graph2[] = (ArrayList<Edge>[]) new ArrayList[v2];
        createGraphDirected(graph2);
        
        toplogicalSortBFS(graph2);
        allPaths(graph2, 0, 5, "");     
      
    }


}
