public class BSTinBT_34 {
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

    static class Info {
        int size;
        int min;
        int max;
        boolean isBST;

        public Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static int maxBSTSize = 0;
    public static Info BSTinBT (Node root) {
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Info leftInfo = BSTinBT(root.left);
        Info righInfo = BSTinBT(root.right);

        int size = leftInfo.size + righInfo.size + 1;
        int min = Math.min(Math.min(leftInfo.min, righInfo.min), root.data);
        int max = Math.max(Math.max(leftInfo.max, righInfo.max), root.data);

        if (root.data <= leftInfo.max || root.data >= righInfo.min) {
            return new Info(size, min, max, false);
        }

        if (leftInfo.isBST && righInfo.isBST) {
            maxBSTSize = Math.max(maxBSTSize, size);
            return new Info(size, min, max, true);
        }

        return new Info(size, min, max, false);
    }


    public static void main(String[] args) {
        Node root = new Node(50);

        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        
        
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        preOrder(root);
        BSTinBT(root);
        System.out.println();
        System.out.println(maxBSTSize);
    }
}
