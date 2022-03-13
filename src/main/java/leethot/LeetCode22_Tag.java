package leethot;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : Dec
 * @date : 2021/7/7 10:40
 */
public class LeetCode22_Tag {
        public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n == 0) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", 0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left == n) {
                for (int i = 0; i < n - node.right; i++) {
                    node.s = node.s + ")";
                }
                res.add(node.s);
                continue;
            }
            if (node.left > node.right) {
                queue.add(new Node(node.s + "(", node.left + 1, node.right));
                queue.add(new Node(node.s + ")", node.left, node.right + 1));
            }
            if (node.left == node.right) {
                queue.add(new Node(node.s + "(", node.left + 1, node.right));
            }
        }
        return res;
    }

    class Node {
        String s;
        // 左括号个数
        int left;
        // 右括号个数
        int right;

        Node(String s, int left, int right) {
            this.s = s;
            this.left = left;
            this.right = right;
        }
    }
}
