public class Tries_37 {
    public static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

    }

    public static class Tries {

        private Node root = new Node();

        public void insert(String key) {
            Node curr = root;

            for (int i = 0; i < key.length(); i++) {
                int idx = (key.charAt(i) - 'a');
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }

            curr.endOfWord = true;
        }

        public boolean search(String key) {
            Node curr = root;

            for (int i = 0; i < key.length(); i++) {
                int idx = key.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    return false;
                }
                curr = curr.children[idx];
            }

            return curr.endOfWord == true;
        }

        public void clear() {
            for (int i = 0; i < root.children.length; i++) {
                root.children[i] = null;
            }
        }

        public boolean wordBreak(String word) {
            if (word.length() == 0) {
                return true;
            }

            for (int i = 1; i <= word.length(); i++) {
                if (search(word.substring(0, i)) && wordBreak(word.substring(i))) {
                    return true;
                }
            }

            return false;
        }

        public int size(Node root) {
            if (root == null) {
                return 0;
            }

            int count = 0;
            for (int i = 0; i < root.children.length; i++) {
                if (root.children[i] != null) {
                    count += size(root.children[i]);
                }
            }

            return count + 1;
        }

    }

    public static class Node2 {
        Node2 children[] = new Node2[26];
        boolean endOfWord = false;
        public int frequency = 1;

        public Node2() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

    }

    public static class Tries2 {
        public Node2 root = new Node2();

        public void insert(String word) {
            Node2 curr = root;

            for (int i = 0; i < word.length(); i++) {
                int idx = (word.charAt(i) - 'a');
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node2();
                } else {
                    curr.children[idx].frequency++;
                }
                curr = curr.children[idx];
            }

            curr.endOfWord = true;
        }

        public void prefixWord(Node2 root, String ans) {
            if (root == null) {
                return;
            }

            if (root.frequency == 1) {
                System.out.println(ans);
                return;
            }

            for (int i = 0; i < root.children.length; i++) {
                prefixWord(root.children[i], ans + (char) ('a' + i));
            }
        }

    }

    public static int uniqueSubstringsCount(String str) {
        Tries t = new Tries();

        for (int i = 0; i < str.length(); i++) {
            t.insert(str.substring(i));
        }

        return t.size(t.root);
    }

    public static String ans = "";

    public static void wordWithAllPrefixes(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null && root.children[i].endOfWord == true) {
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                wordWithAllPrefixes(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {

        Tries trie = new Tries();
        String[] arr = { "i", "love", "sam", "hello" };

        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i]);
        }

        String test1 = "ilovesamsung";
        String test2 = "hellosam";
        String test3 = "boisam";

        System.out.println(trie.wordBreak(test1));
        System.out.println(trie.wordBreak(test2));
        System.out.println(trie.wordBreak(test3));

        Tries2 t = new Tries2();
        t.root.frequency = -1;
        String[] arr3 = { "zebra", "dog", "dam", "dove", "zip" };

        for (int i = 0; i < arr3.length; i++) {
            t.insert(arr3[i]);
        }

        t.prefixWord(t.root, "");

        String str = "ababa";
        System.out.println(uniqueSubstringsCount(str));

        Tries t2 = new Tries();
        String[] word = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < word.length; i++) {
            t2.insert(word[i]);
        }
        wordWithAllPrefixes(t2.root, new StringBuilder(""));
        System.out.println(ans);
    }

}
