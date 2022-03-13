package leethot;

import java.util.LinkedList;

/**
 * @author : Dec
 * @date : 2021/7/9 16:18
 * <p>
 * 方法：遍历到当前节点时，把当前节点的左右子树交换一下，因此多种遍历方法都可以
 * <p>
 * 三种思路：
 * 先序深度遍历
 * 先序迭代遍历
 * 层次遍历
 */
public class LeetCode226 {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        preOrder(root);
        dfs(root);
        return root;
    }

    public void preOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);

                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;

                root = root.left;
            }

            while (root == null && !stack.isEmpty()) {
                root = stack.pop().right;
            }
        }
    }


    public void levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
    }


    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        dfs(root.left);
        dfs(root.right);
    }


    public class TreeNode {
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
