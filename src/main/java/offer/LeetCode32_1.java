package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * @author Dec
 * 二叉树的层次遍历法
 */
public class LeetCode32_1 {

    @Test
    public void test() {
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            list.add(node.val);

            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
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
