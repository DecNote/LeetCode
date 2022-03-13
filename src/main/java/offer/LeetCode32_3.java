package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Dec
 * 二叉树的层次遍历法，且按层打印，且之字形打印
 */
public class LeetCode32_3 {

    @Test
    public void test() {
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> res = new ArrayList<>();
        int level = 1;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.remove(0);
                if (level % 2 == 0) {
                    temp.add(0, node.val);
                } else {
                    temp.add(node.val);
                }

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(temp);
            level++;
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
