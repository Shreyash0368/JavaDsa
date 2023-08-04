import java.util.*;

public class GraphSupllement_43 {
    static class Edge implements Comparable<Edge> {
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

        public int compareTo(Edge e2) {
            return this.weight - e2.weight;
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
        graph[3].add(new Edge(3, 1));

        // 4
        // graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4, 2));

        // 5
        graph[5].add(new Edge(5, 6));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 3));

        // 6
        graph[6].add(new Edge(6, 5));

    }

    public static void createGraphDirected(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0
        graph[0].add(new Edge(0, 1));

        // 1
        graph[1].add(new Edge(1, 2));

        // 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));

        // 3
        graph[3].add(new Edge(3, 4));

        // 4
        graph[4].add(new Edge(4, 7));
        graph[4].add(new Edge(4, 5));

        // 5
        graph[5].add(new Edge(5, 6));

        // 7
        graph[6].add(new Edge(6, 7));
        graph[6].add(new Edge(6, 4));
    }

    public static ArrayList<Edge> bridgeInGraph(ArrayList<Edge> graph[]) {
        ArrayList<Edge> bridges = new ArrayList<>();
        boolean vis[] = new boolean[graph.length];
        int depth[] = new int[graph.length];
        int lowest[] = new int[graph.length];

        bridgeInGraphUtil(graph, 0, -1, 1, vis, depth, lowest, bridges);

        return bridges;
    }

    private static void bridgeInGraphUtil(ArrayList<Edge> graph[], int curr, int parent, int i, boolean vis[],
            int depth[], int lowest[], ArrayList<Edge> bridge) {
        if (vis[curr]) {
            return;
        }

        vis[curr] = true;
        depth[curr] = lowest[curr] = i;

        for (int j = 0; j < graph[curr].size(); j++) {
            Edge e = graph[curr].get(j);
            if (e.dest == parent) continue;

            if (!vis[e.dest]) {
                bridgeInGraphUtil(graph, e.dest, curr, i + 1, vis, depth, lowest, bridge);
                lowest[curr] = Math.min(lowest[curr], lowest[e.dest]);
            } else {
                lowest[curr] = Math.min(lowest[curr], lowest[e.dest]);
            }

            if (depth[curr] < lowest[e.dest]) {
                bridge.add(e);
            }
        }

    }

    // graph from striver video
    public static int stronglyConnected(ArrayList<Edge> graph[]) { // the graph should be directed
        int count = 0;
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();

        stronglyConnectedDFS(graph, 0, vis, st);

        vis = new boolean[graph.length];
        
        // creating reverse graph
        ArrayList<Edge> reverse[] = new ArrayList[graph.length];
        for (int i = 0; i < reverse.length; i++) {
            reverse[i] = new ArrayList<>();
        } 

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) { // reversing graph
                Edge e = graph[i].get(j);
                reverse[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!vis[curr]) {
                count++;
                stronglyConnectedDFS2(reverse, curr, vis);
            }
        }

        return count;
    }

    private static void stronglyConnectedDFS(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> st) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                stronglyConnectedDFS(graph, e.dest, vis, st);
            }
        }

        st.push(curr);
    }

    private static void stronglyConnectedDFS2(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        if (vis[curr])
            return;
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                stronglyConnectedDFS2(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraphUndirected(graph);
        ArrayList<Edge> bridge;
        bridge = bridgeInGraph(graph);

        for (int i = 0; i < bridge.size(); i++) {
            System.out.println(bridge.get(i).src + " : " + bridge.get(i).dest);
        }

        int v2 = 8;
        ArrayList<Edge> graph2[] = new ArrayList[v2];
        createGraphDirected(graph2);
        System.out.println("----------");
        System.out.println(stronglyConnected(graph2));

    }
}
