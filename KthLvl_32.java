public class KthLvl_32 {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static void kthLvlNodes(Node root, int k, int i) { // k is the target lvl while i is the current lvl
        if (root == null) {
            return;
        }

        if (i == k) {
            System.out.print(root.data + " ");
            return;
        }

        kthLvlNodes(root.left, k, i + 1);
        kthLvlNodes(root.right, k, i + 1);
    }

    public static int kthAncestor(Node root, int n, int k) { // n is the node and k is the lvl of ancestor
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int left = kthAncestor(root.left, n, k);
        int right = kthAncestor(root.right, n, k);

        if (left == -1 && right == -1) {
            return -1;
        }

        int max = Math.max(left, right) + 1;

        if (max == k)
            System.out.println(root.data);

        return max;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        kthAncestor(root, 6, 1);
        kthLvlNodes(root, 2, 0);
    }

}
