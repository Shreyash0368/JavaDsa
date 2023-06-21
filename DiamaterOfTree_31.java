public class DiamaterOfTree_31 {
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

    public static class Info {
        int diameter;
        int height;

        public Info (int d, int h) {
            diameter = d;
            height = h;
        }
    }
    
    public static int heightOfTree(Node root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            return (Integer.max(leftHeight, rightHeight) + 1);
        }

    public static int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        // calculating largest path which includes the root node
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int selfDm = leftHeight + rightHeight + 1;

        // calculating left and right diameter seperately
        int leftDm = diameterOfTree(root.left);
        int rigthDm = diameterOfTree(root.right);

        return Math.max(selfDm, Math.max(leftDm, rigthDm));
    }

    public static Info diameterOfTree2(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameterOfTree2(root.left);
        Info rightInfo = diameterOfTree2(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int diameter = Math.max((leftInfo.height + rightInfo.height + 1), Math.max(leftInfo.diameter, rightInfo.diameter));

        return new Info(diameter, height);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameterOfTree(root));
        System.out.println(diameterOfTree2(root).diameter);
    }
}
