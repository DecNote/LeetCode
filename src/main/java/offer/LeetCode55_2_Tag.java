package offer;

import org.junit.Test;

import java.util.ArrayList;


/**
 * @author Dec
 * <p>
 * 1. 深度遍历
 * 2. 自己多写几遍，和上一道题联系比较大
 */
public class LeetCode55_2_Tag {

    @Test
    public void test() {
        int[][] a =new int[2][];

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 当前节点的左右子树深度差小于1
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        // 当前节点的左右子树深度差大于1
        return false;

    }

    /**
     * 获取树的深度
     *
     * @param root
     * @return
     */
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
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
