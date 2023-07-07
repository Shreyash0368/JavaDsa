import java.util.PriorityQueue;

public class PQQuestions_35 {
    public static class Solider implements Comparable<Solider> {
        int idx;
        int strength;

        public Solider(int i, int[] arr) {
            this.idx = i;

            for (int j = 0; j < arr.length; j++) {
                this.strength += arr[j];
            }
        }

        @Override
        public int compareTo(Solider s2) {
            if (this.strength != s2.strength) {
                return this.strength - s2.strength;
            } else {
                return this.idx - s2.idx;
            }
        }
    }

    public static class NumberInfo implements Comparable<NumberInfo> {
        int idx;
        int value;

        public NumberInfo(int idx, int val) {
            this.idx = idx;
            this.value = val;
        }

        @Override
        public int compareTo(NumberInfo n2) {
            return n2.value - this.value;
        }
    }

    public static int connectNRopes(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size() != 1) {
            int rope1 = pq.remove();
            int rope2 = pq.remove();
            cost += rope1 + rope2;
            pq.add(rope1 + rope2);
        }

        return cost;
    }

    public static void weakestSolider(int[][] formation, int k) {
        PriorityQueue<Solider> pq = new PriorityQueue<>();

        for (int i = 0; i < formation.length; i++) {
            pq.add(new Solider(i, formation[i]));
        }

        for (int i = 0; i < k; i++) {
            Solider temp = pq.remove();
            System.out.println(temp.idx + " : " + temp.strength);
        }
    }

    public static void slidingWindowMax(int[] array, int k) {
        PriorityQueue<NumberInfo> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(new NumberInfo(i, array[i]));
        }
        System.out.print(pq.peek().value + " ");

        for (int i = k ; i < array.length; i++) {            
            while (pq.peek().idx < (i - k)) {
                pq.remove();
            }

            pq.add(new NumberInfo(i, array[i]));
            System.out.print(pq.peek().value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] ropes = { 2, 3, 3, 4, 6 };
        System.out.println(connectNRopes(ropes));

        int[][] formation = { { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };

        weakestSolider(formation, 2);

        int [] array = {1, 3, -1, 5, 3, 6, 7, 8, 4};
        slidingWindowMax(array, 4);
    }

}
