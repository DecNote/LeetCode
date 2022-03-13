package leethot;

/**
 * @author : Dec
 * @date : 2021/6/21 22:23
 */
public class LeetCode538 {


    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }


    private int sum = 0;

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
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
