package leethot;

/**
 * @author : Dec
 * @date : 2021/6/21 22:42
 */
public class LeetCode543 {
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return res;

    }

    private int res = 0;

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left + right > res) {
            res = left + right;
        }
        return Math.max(left, right) + 1;
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
