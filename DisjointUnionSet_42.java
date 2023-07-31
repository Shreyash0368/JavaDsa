public class DisjointUnionSet_42 {
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

        public void unionBySize(int i, int j) {
            int ultPrI = ultParent(i);
            int ultPrJ = ultParent(j);

            if (ultPrI == ultPrJ)
                return;

            if (size[ultPrJ] > size[ultPrI]) {                
                parent[ultPrI] = ultPrJ;
                size[ultPrJ] += size[ultPrI];
            } else {
                parent[ultPrJ] = ultPrI;
                size[ultPrI] += size[ultPrJ];                
            }
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

    public static void main(String[] args) {
        DSU ds = new DSU(6);
        ds.printDetails();
        ds.unionBySize(0, 1);
        ds.unionBySize(0, 2);
        ds.unionBySize(2, 5);
        ds.printDetails();
    }
}
