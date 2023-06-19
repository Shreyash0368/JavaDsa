import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeChap_30 {
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

    public static class Tree {
        int idx = -1;

        public Node buildTreePreOrdr(int nodes[]) { // array of values for the nodes
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTreePreOrdr(nodes);
            newNode.right = buildTreePreOrdr(nodes);

            return newNode;
        }

        public void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void postOrder(Node root) {
            if (root == null) {
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public void levelOrder(Node root) {
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
                    }
                    else {
                        q.add(null);
                    }
                }
                else {
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

        public int heightOfTree(Node root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            return (Integer.max(leftHeight, rightHeight) + 1);
        }

        public int nodeCount(Node root) {
            if (root == null) {
                return 0;
            }

            int leftCount = nodeCount(root.left);
            int rightCount = nodeCount(root.right);

            return leftCount + rightCount + 1;
        }

        public int sumOfNode(Node root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sumOfNode(root.left);
            int rightSum = sumOfNode(root.right);

            return leftSum + rightSum + root.data;
        }
    }

    public static void main(String[] args) {
        int nodeArr[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1} ;
        Tree tree = new Tree();
        Node root = tree.buildTreePreOrdr(nodeArr);
        // tree.preOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        tree.levelOrder(root);
        System.out.println(tree.heightOfTree(root));
        System.out.println(tree.nodeCount(root));
        System.out.println(tree.sumOfNode(root));
    }
}
