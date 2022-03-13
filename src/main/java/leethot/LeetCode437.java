package leethot;

/**
 * @author : Dec
 * @date : 2021/6/21 16:40
 */
public class LeetCode437 {
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfsTree(root);
        return this.res;

    }

    private int res = 0;
    private int targetSum;


    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum = sum + root.val;

        if (sum == targetSum) {
            res++;
        }

        dfs(root.left, sum);
        dfs(root.right, sum);

    }


    public void dfsTree(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root, 0);

        dfsTree(root.left);
        dfsTree(root.right);
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
