package leethot;


/**
 * @author : Dec
 * @date : 2021/6/16 22:41
 * <p>
 * 1. 字典树
 * 2. 如何定义节点
 */
public class LeetCode208 {
    class Trie {

        Node root = new Node();

        /**
         * Initialize your data structure here.
         */
        public Trie() {
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node p = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int pos = ch - 'a';
                if (p.child[pos] == null) {
                    p.child[pos] = new Node();
                }
                p = p.child[pos];
            }
            p.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node p = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int pos = ch - 'a';
                if (p.child[pos] != null) {
                    p = p.child[pos];
                } else {
                    return false;
                }
            }

            return p.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node p = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int pos = ch - 'a';
                if (p.child[pos] != null) {
                    p = p.child[pos];
                } else {
                    return false;
                }
            }

            return true;
        }
    }


    class Node {
        Node[] child = new Node[26];
        /**
         * isEnd表示到当前节点可否是word的终点
         */
        boolean isEnd = false;

        public boolean isLeaf(Node node) {
            for (int i = 0; i < 26; i++) {
                if (node.child[i] != null) {
                    return false;
                }
            }
            return true;
        }
    }
}
