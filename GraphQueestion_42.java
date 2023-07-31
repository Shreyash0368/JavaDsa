import java.util.*;

public class GraphQueestion_42 {
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

    static class Info implements Comparable<Info> {
        int src;
        int cost;
        int k;
        String path;

        public Info(int s, int c, int k, String p) {
            this.src = s;
            this.cost = c;
            this.k = k;
            this.path = p;
        }

        @Override
        public int compareTo(Info i2) {
            if (this.cost != i2.cost) {
                return this.cost - i2.cost;
            } else {
                return this.k - i2.k;
            }
        }

    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int weight = flights[i][2];

            graph[src].add(new Edge(src, dest, weight));
        }
    }

    public static void cheapestFlightKStops(ArrayList<Edge> graph[], int src, int dest, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, 0, 0, ""));

        while (!pq.isEmpty()) {
            Info i = pq.remove();

            if (i.k > k + 1) {
                continue;
            } else if (i.src == dest) {
                System.out.println("The shortest path is " + i.path + i.src + " with the cost: " + i.cost);
                return;
            }

            for (int j = 0; j < graph[i.src].size(); j++) {
                Edge e = graph[i.src].get(j);
                pq.add(new Info(e.dest, i.cost + e.weight, i.k + 1, i.path + e.src));
            }
        }

        System.out.println("no path possible: " + -1);
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];
        int finalCost = 0;

        pq.add(new Edge(0, 0, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (vis[curr.dest])
                continue;

            vis[curr.dest] = true;
            finalCost += curr.weight;

            for (int i = 0; i < cities[curr.dest].length; i++) {
                if (cities[curr.dest][i] != 0) {
                    pq.add(new Edge(curr.dest, i, cities[curr.dest][i]));
                }
            }
        }

        return finalCost;
    }

    public static void floodFill(int image[][], int sr, int sc, int color) {
        if (sr >= image.length || sr < 0 || sc >= image.length || sc < 0) {
            System.out.println("invalid");
            return;
        }

        int oldColor = image[sr][sc];
        floodFillUtil(image, sr, sc, oldColor, color);
    }

    private static void floodFillUtil(int image[][], int sr, int sc, int oldColor, int newColor) {
        if (sr >= image.length || sr < 0 || sc >= image.length || sc < 0 || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;

        floodFillUtil(image, sr + 1, sc, oldColor, newColor);
        floodFillUtil(image, sr - 1, sc, oldColor, newColor);
        floodFillUtil(image, sr, sc + 1, oldColor, newColor);
        floodFillUtil(image, sr, sc - 1, oldColor, newColor);

    }

    public static void main(String[] args) {
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(flights, graph);
        cheapestFlightKStops(graph, 0, 1, 2);

        int cities[][] = {
                { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

        System.out.println(connectCities(cities));

        int image[][] = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };

        floodFill(image, 1, 1, 2);
        
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

}
