import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath_4041 {
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

    public static int[] dijkstraAlgo(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        int distance[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            visited[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if ((distance[curr] + e.weight) < distance[e.dest]) {
                    distance[e.dest] = distance[curr] + e.weight;
                }
                q.add(e.dest);
            }
        }

        return distance;
    }

    public static int[] bellmanFord(ArrayList<Edge> graph[]) {
        int distance[] = new int[graph.length];
        for (int i = 1; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // running the relaxation loop v - 1 time (basically run dijkstra V - 1 times)
        for (int i = 0; i < distance.length - 1; i++) {
            for (int curr = 0; curr < distance.length; curr++) {
                for (int j = 0; j < graph[curr].size(); j++) {
                    Edge e = graph[curr].get(j);
                    if ((distance[e.src] != Integer.MAX_VALUE) && (distance[e.src] + e.weight < distance[e.dest])) {
                        distance[e.dest] = distance[e.src] + e.weight;
                    }
                }
            }
        }

        // perforing the check one last time to check for negative cycle, if distance
        // updates that means negative cycle present
        for (int curr = 0; curr < distance.length; curr++) {
            for (int j = 0; j < graph[curr].size(); j++) {
                Edge e = graph[curr].get(j);
                if ((distance[e.src] != Integer.MAX_VALUE) && (distance[e.src] + e.weight < distance[e.dest])) {
                    return new int[] { -1 }; // we return this to denote negative cycle
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int v2 = 6;
        ArrayList<Edge> graph2[] = (ArrayList<Edge>[]) new ArrayList[v2];
        createGraphDirected(graph2);        
        int distance[];
        
        distance = bellmanFord(graph2);
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
        
        distance = dijkstraAlgo(graph2);
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }


}
