package leethot;

import java.util.LinkedList;

/**
 * @author : Dec
 * @date : 2021/7/5 14:29
 * <p>
 * 1. 对称二叉树验证，即两棵树的同时遍历
 * 2. 分别使用dfs和层次遍历
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
    }

    public boolean levelOrder(TreeNode root1, TreeNode root2) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.removeFirst();
            TreeNode node2 = queue.removeFirst();


            if (node1 == null && node2 == null) {
                // 不需要再添加node1和node2的子节点
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }

            queue.add(node1.left);
            queue.add(node2.right);

            queue.add(node1.right);
            queue.add(node2.left);

        }
        return true;
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
