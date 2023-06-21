public class CheckForSubtree_31 {
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

    public static Node findNode(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.data == val) {
            return root;
        }

        Node valNodeLeft = findNode(root.left, val);
        Node valNodeRight = findNode(root.right, val);

        return (valNodeLeft == null) ? valNodeRight : valNodeLeft;
    }

    public static boolean checkIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root.data != subRoot.data || root == null || subRoot == null) {
            return false;
        }

        boolean leftCheck = checkIdentical(root.left, subRoot.left);
        boolean rightCheck = checkIdentical(root.right, subRoot.right);

        return leftCheck && rightCheck;
    }

     public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null)
            return false;
        if (subRoot == null)
            return true;

        Node subNode = findNode(root, subRoot.data);

        if (subNode == null)
            return false;

        return checkIdentical(subNode, subRoot);
    }
    
    // more efficient implementation from lecture
    public static boolean isSubtree2(Node root, Node subRoot) {
       if (subRoot == null) return true;
       if (root == null) return false;

        if (root.data == subRoot.data) {
           return checkIdentical(root, subRoot);
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }   

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(3);
        subRoot.left = new Node(6);
        subRoot.right = new Node(7);

        Node subRoot2 = new Node(3);
        subRoot2.left = new Node(9);
        subRoot2.right = new Node(7);

        System.out.println(isSubtree(root, subRoot));
        System.out.println(isSubtree2(root, subRoot));

        System.out.println(isSubtree(root, subRoot2));
        System.out.println(isSubtree2(root, subRoot2));

    }
}
