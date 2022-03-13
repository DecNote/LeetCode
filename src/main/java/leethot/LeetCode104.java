package leethot;

import java.util.LinkedList;

/**
 * @author : Dec
 * @date : 2021/7/6 16:30
 * <p>
 * 1. 递归和非递归两种思路
 */
public class LeetCode104 {


    public int maxDepth(TreeNode root) {
//        return dfs(root);
        return levelOrder(root);
    }


    /**
     * 递归解法
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }


    /**
     * 非递归解法：层次遍历
     */
    public int levelOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            res++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
