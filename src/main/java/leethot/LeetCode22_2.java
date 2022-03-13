package leethot;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : Dec
 * @date : 2021/7/10 10:40
 * <p>
 * 有效括号生成问题
 * 可以使用广度优先搜索，但是需要自己定义节点
 */
public class LeetCode22_2 {

    @Test
    public void test() {
        System.out.println(generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        return levelOrder(new Node(0, 0, ""), n);
    }

    public List<String> levelOrder(Node root, int n) {
        LinkedList<Node> queue = new LinkedList<>();
        List<String> res = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();

            if (node.leftNum == n) {
                for (int i = 0; i < n - node.rightNum; i++) {
                    node.s = node.s + ")";
                }
                res.add(node.s);
                continue;
            }

            if (node.leftNum > node.rightNum) {
                queue.add(new Node(node.leftNum + 1, node.rightNum, node.s + "("));
                queue.add(new Node(node.leftNum, node.rightNum + 1, node.s + ")"));
            } else {
                queue.add(new Node(node.leftNum + 1, node.rightNum, node.s + "("));
            }
        }
        return res;

    }

    class Node {
        int leftNum;
        int rightNum;
        String s;

        public Node(int leftNum, int rightNum, String s) {
            this.leftNum = leftNum;
            this.rightNum = rightNum;
            this.s = s;
        }
    }
}
