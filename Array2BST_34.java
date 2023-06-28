import java.util.*;

public class Array2BST_34 {
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

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        // here we use BFS (breadth first search) i.e we use queue
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
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

    public static Node sortedArray2BST(ArrayList<Integer> arr, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;
        Node newNode = new Node(arr.get(mid));
        newNode.left = sortedArray2BST(arr, st, mid - 1);
        newNode.right = sortedArray2BST(arr, mid + 1, end);

        return newNode;
    }

    public static void getIonorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        getIonorder(root.left, inorder);
        inorder.add(root.data);
        getIonorder(root.right, inorder);
    }

    public static Node BalancedBST(Node root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> inorder = new ArrayList<>();
        getIonorder(root, inorder);

        return sortedArray2BST(inorder, 0, inorder.size() - 1);
    }

    public static void main(String[] args) {
        // balance a bst
        Node root = new Node(6);
        addToBST(root, 2);
        addToBST(root, 3);
        addToBST(root, 5);
        addToBST(root, 8);
        addToBST(root, 1);
        addToBST(root, 7);
        addToBST(root, 4);        

        levelOrder(root);        
        Node root3 = BalancedBST(root);
        System.out.println();
        levelOrder(root3);
        System.out.println("---------------");

        // array 2 bst 
        ArrayList<Integer> array = new ArrayList<>();
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);

        Node root2 = sortedArray2BST(array, 0, array.size() - 1);
        preOrder(root2);


    }
}
