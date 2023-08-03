import java.util.*;

public class PrimsNKruskal_4142 {
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

    public static class DSU {
        int size[];
        int parent[];

        public DSU(int n) {
            size = new int[n];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int ultParent(int i) {
            if (i == parent[i]) {
                return i;
            }

            int p = ultParent(parent[i]);
            parent[i] = p;
            return parent[i];
        }

        public boolean unionBySize(int i, int j) {
            int ultPrI = ultParent(i);
            int ultPrJ = ultParent(j);

            if (ultPrI == ultPrJ)
                return false;

            if (size[ultPrJ] > size[ultPrI]) {
                parent[ultPrI] = ultPrJ;
                size[ultPrJ] += size[ultPrI];
            } else {
                parent[ultPrJ] = ultPrI;
                size[ultPrI] += size[ultPrJ];
            }

            return true;
        }

        public void printDetails() {
            System.out.print("size: ");
            for (int i = 0; i < parent.length; i++) {
                System.out.print(size[i] + " ");
            }
            System.out.println();
            System.out.print("parent: ");
            for (int i = 0; i < parent.length; i++) {
                System.out.print(parent[i] + " ");
            }
            System.out.println();
        }
    }

    public static void createGraphUndirected(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 4, 4));
        graph[0].add(new Edge(0, 3, 1));

        // 1
        graph[1].add(new Edge(1,3,3));
        graph[1].add(new Edge(1,3,3));
        graph[1].add(new Edge(1,2,3));
        graph[1].add(new Edge(1,5,7));

        // 2
        graph[2].add(new Edge(2, 5, 8));
        graph[2].add(new Edge(2, 3, 5));

        // 3
        graph[3].add(new Edge(3, 4, 9));

    }

    public static void createGraphDirected(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0
        graph[0].add(new Edge(0, 4, 8));
        graph[0].add(new Edge(0, 1, 3));
        graph[0].add(new Edge(0, 3, 7));

        // 1
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 4));

        // 2

        // 3
        graph[3].add(new Edge(3, 2, 2));

        // 4
        graph[4].add(new Edge(4, 3, 3));

    }

    public static int primsMST(ArrayList<Edge> graph[]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[graph.length];
        int sum = 0;

        pq.add(new Edge(0, 0, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (visited[curr.dest])
                continue;

            visited[curr.dest] = true;
            sum += curr.weight;

            for (int i = 0; i < graph[curr.dest].size(); i++) {
                pq.add(graph[curr.dest].get(i));
            }
        }

        return sum;
    }

    public static int kruskalMST(ArrayList<Edge> graph[]) {
        DSU ds = new DSU(graph.length);
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int sum = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                pq.add(graph[i].get(j));
            }
        }

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            // if ((vis[curr.src] && vis[curr.dest]))
            //     continue;

            // vis[curr.src] = vis[curr.dest] = true;
            if (ds.unionBySize(curr.src, curr.dest)) {
                sum += curr.weight;
            }
        }

        // ds.printDetails();

        return sum;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraphDirected(graph);
        System.out.println(primsMST(graph));
        System.out.println(kruskalMST(graph));
        System.out.println("---------------------");
        // int v2 = 6;
        // ArrayList<Edge> graph2[] = new ArrayList[v2];
        // System.out.println(primsMST(graph2));
        // System.out.println(kruskalMST(graph2));

    }

}
