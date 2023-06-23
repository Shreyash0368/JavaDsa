public class BSTBasics_33 {
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

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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

    public static Node searchInBST(Node root, int n) {
        if (root == null || root.data == n) {
            return root;
        }

        if (root.data > n) {
            return searchInBST(root.left, n);
        } else {
            return searchInBST(root.right, n);
        }
    }

    public static int inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }

    public static Node deleteInBST(Node root, int n) {
        if (root == null) {
            return null;
        }

        if (root.data > n) {
            root.left = deleteInBST(root.left, n);
        } else if (root.data < n) {
            root.right = deleteInBST(root.right, n);
        } else {
            // case 1
            if (root.right == null && root.left == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int successor = inorderSuccessor(root.right);
                root.data = successor;
                root.right = deleteInBST(root.right, successor);
            }
        }

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

        inOrder(root);
        System.out.println();

        // Node temp = searchInBST(root, 2);
        // System.out.println(temp != null ? temp.data : null);
        deleteInBST(root, 3);
        deleteInBST(root, 2);
        deleteInBST(root, 2);
        inOrder(root);
    }

}
