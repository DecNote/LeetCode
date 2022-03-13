package offer;

import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 深度遍历
 * 2. 层次遍历
 * 3. 递归思想，划分子问题：当前节点的深度等于 左子树深度 和 右子树深度 的最大值 加1
 */
public class LeetCode55_1_Tag {

    @Test
    public void test() {

    }


    /**
     * 【推荐版本】
     */
    public int maxDepthLeet(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    private int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return this.max;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth > max) {
            max = depth;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
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
