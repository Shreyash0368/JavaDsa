
public class MinDistanceNSumTree_32 {
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

    public static int lcaDistance(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDistance(root.left, n);
        int rightDist = lcaDistance(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        return Math.max(leftDist, rightDist) + 1;
    }

    public static Node lca2(Node root, int r1, int r2) {
        if (root == null || root.data == r1 || root.data == r2) {
            return root;
        }

        Node leftLca = lca2(root.left, r1, r2); // cecking if left subtree contains both same for right
        Node rightLca = lca2(root.right, r1, r2);

        if (rightLca == null) { // if right returns null that means both noeds exist in left subtree itself .i.e
                                // the lca exists inside the left subtree
            return leftLca;
        }
        if (leftLca == null) { // vice versa
            return rightLca;
        }

        // if both are not null then one node in left and one in right .i.e the curr
        // node is common ancesot to both
        return root;
    }

    public static int minDistance(Node root, int n1, int n2) {
        if (root == null || n1 == n2) {
            return 0;
        }

        Node lca = lca2(root, n1, n2);

        int distance1 = lcaDistance(lca, n1);
        int distance2 = lcaDistance(lca, n2);

        return distance1 + distance2;
    }

    public static int sumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        int data = root.data;

        root.data = leftSum + rightSum;

        return data + root.data;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        
        System.out.println(minDistance(root, 4, 7));
        preOrder(root);
        System.out.println();
        sumTree(root);
        preOrder(root);
    }

}
