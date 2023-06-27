import java.util.ArrayList;

public class RangePath_33 {
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

    public static void printInRange(Node root, int l1, int l2) {
        if (root == null) {
            return;
        }

        if (root.data > l1 && root.data < l2) {
            printInRange(root.left, l1, l2);
            System.out.print(root.data + " ");
            printInRange(root.right, l1, l2);
        } else if (root.data <= l1) {
            printInRange(root.right, l1, l2);
        } else if (root.data >= l2) {
            printInRange(root.left, l1, l2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void root2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            root2Leaf(root.left, path);
            root2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
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
        
        System.out.println("---Printing in range (1 - 7)---");
        printInRange(root, 1, 7);
        System.out.println();
        System.out.println("Printing all paths from root to leaf nodes");
        ArrayList<Integer> path = new ArrayList<>();
        root2Leaf(root, path);
    }

}
