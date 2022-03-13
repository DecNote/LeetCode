package leethot;

import java.util.HashSet;

/**
 * @author : Dec
 * @date : 2021/6/16 22:41
 */
public class LeetCode208_b {
    class Trie {

        HashSet<String> set = new HashSet<>();

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            set.add(word);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return set.contains(word);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            for (String s : set) {
                if (s.startsWith(prefix)) {
                    return true;
                }
            }
            return false;
        }
    }
}
