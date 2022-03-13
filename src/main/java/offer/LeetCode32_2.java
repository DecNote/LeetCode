package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Dec
 * 二叉树的层次遍历法，且按层打印
 */
public class LeetCode32_2 {

    @Test
    public void test() {
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.remove(0);
                temp.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
