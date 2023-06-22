import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopNBottomView_31 {
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
        Node node;
        int horizontalDis;

        public Info(Node n, int hd) {
            node = n;
            horizontalDis = hd;
        }
    }

    public static void topViewOfTree(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.horizontalDis)) {
                    map.put(curr.horizontalDis, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.horizontalDis - 1));
                    min = Math.min(min, curr.horizontalDis - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.horizontalDis + 1));
                    max = Math.max(max, curr.horizontalDis + 1);
                }
            }
        }

        for (int i = min; i < max + 1; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void bottomViewOfTree(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {

                map.put(curr.horizontalDis, curr.node);

                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.horizontalDis - 1));
                    min = Math.min(min, curr.horizontalDis - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.horizontalDis + 1));
                    max = Math.max(max, curr.horizontalDis + 1);
                }
            }
        }

        for (int i = min; i < max + 1; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topViewOfTree(root);
        bottomViewOfTree(root);

    }
}
