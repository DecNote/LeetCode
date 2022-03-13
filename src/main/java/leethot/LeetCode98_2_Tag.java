package leethot;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/7/5 13:39
 * <p>
 * 二叉搜索树丁定义：如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树。
 */
public class LeetCode98_2_Tag {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(isValidBST(root));
    }


    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    /**
     * 左子树有上界，即root.val
     * 右子树有下界，即root.va
     */
    public boolean dfs(TreeNode root, long lower, long upper) {

        if (root == null) {
            return true;
        }
        System.out.println(root.val + "   " + lower + "  " + upper);
        if (root.val >= upper || root.val <= lower) {
            return false;
        }
        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
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
