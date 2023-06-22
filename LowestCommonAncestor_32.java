import java.util.ArrayList;

public class LowestCommonAncestor_32 {
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

      public static boolean getPath(Node root, int r1, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == r1) {
            return true;
        }

        boolean leftFind = getPath(root.left, r1, path); // check if value exists in left subtree
        boolean rightFind = getPath(root.right, r1, path); // check if value exists in right subtree
        // since one node cannot exist in both 1 of them will return false

        if (leftFind) {
            return true;
        }

        if (rightFind) {
            return true;
        }

        // if both return then current node is not part of path, hence it is removed
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int r1, int r2) {
        if (root == null || root.data == r1 || root.data == r2) {
            return root;
        }

        ArrayList<Node> p1 = new ArrayList<>();
        ArrayList<Node> p2 = new ArrayList<>();

        boolean r1Exists = getPath(root, r1, p1);
        boolean r2Exists = getPath(root, r2, p2);

        int i = 0;
        if (r1Exists && r2Exists) { // the path to both nodes MUST exist i.e. both values should be part of the tree
            for (i = 0; i < p1.size() && i < p2.size(); i++) {
                if (p1.get(i) != p2.get(i)) {
                    break;
                }
            }
        } else {
            return null;
        }

        return p1.get(i - 1);

    }

    public static Node lca2(Node root, int r1, int r2) {
        if (root == null || root.data == r1 || root.data == r2) {
            return root;
        }

        Node leftLca = lca2(root.left, r1, r2); // cecking if left subtree contains both same for right
        Node rightLca = lca2(root.right, r1, r2);

        if (rightLca == null) { // if right returns null that means both noeds exist in left subtree itself .i.e the lca exists inside the left subtree
            return leftLca;
        }
        if (leftLca == null) { // vice versa
            return rightLca;
        }

        // if both are not null then one node in left and one in right .i.e the curr node is common ancesot to both
        return root;
    }


    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // kthLvlNodes(root, 2, 0);
        Node ancestor = lca(root, 5, 4);
        System.out.println((ancestor == null) ? null : ancestor.data);
        ancestor = lca2(root, 5, 4);
        System.out.println((ancestor == null) ? null : ancestor.data);


    }


}
