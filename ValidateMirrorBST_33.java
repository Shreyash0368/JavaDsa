public class ValidateMirrorBST_33 {
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

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void addToBST(Node root, int n) {
        Node newNode = new Node(n);
        if (root == null) {
            root = newNode;
            return;
        }

        if (root.data == n) {
            return;
        }

        if (root.data > n) {
            if (root.left == null) {
                root.left = newNode;
            } else {
                addToBST(root.left, n);
            }
        } else {
            if (root.right == null) {
                root.right = newNode;
            } else {
                addToBST(root.right, n);
            }
        }
    }

    public static boolean validateBST(Node root, Node min, Node max) { // a simple approach will be to just print the
                                                                       // tree inOrder and check if all no are ascending
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }

        if (max != null && root.data >= max.data) {
            return false;
        }

        return validateBST(root.left, min, root) && validateBST(root.right, root, max);
    }

    public static Node mirrorBST(Node root) {
        if (root == null) {
            return null;
        }

        Node temp = root.right;
        root.right = root.left;
        root.left = temp;

        root.right = mirrorBST(root.right);
        root.left = mirrorBST(root.left);

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        addToBST(root, 2);
        addToBST(root, 3);
        addToBST(root, 7);
        addToBST(root, 8);
        addToBST(root, 1);
        addToBST(root, 6);
        addToBST(root, 4);

        inOrder(root);
        System.out.println();
        System.out.println(validateBST(root, null, null));

        // inacurate tree
        Node root2 = new Node(5);

        root2.left = new Node(3);
        root2.right = new Node(8);

        root2.left.left = new Node(1);
        root2.left.right = new Node(4);

        root2.right.left = new Node(6);
        root2.right.right = new Node(4);
        inOrder(root2);
        System.out.println();
        System.out.println(validateBST(root2, null, null));

        System.out.println("-----mirroring BST-----");
        root = mirrorBST(root);
        inOrder(root);

    }

}
