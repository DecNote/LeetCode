package leethot;

/**
 * @author : Dec
 * @date : 2021/6/22 10:51
 */
public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    public TreeNode dfs(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null && root2 != null) {
            return root2;
        }

        if (root1 != null && root2 == null) {
            return root1;
        }

        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = dfs(root1.left, root2.left);
        root.right = dfs(root1.right, root2.right);
        return root;
    }

/*
    public TreeNode dfs(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null && root2 != null) {
            TreeNode root = new TreeNode(root2.val);
            root.left = dfs(root1, root2.left);
            root.right = dfs(root1, root2.right);
            return root;
        }

        if (root1 != null && root2 == null) {
            TreeNode root = new TreeNode(root1.val);
            root.left = dfs(root1.left, root2);
            root.right = dfs(root1.right, root2);
            return root;
        }

        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = dfs(root1.left, root2.left);
        root.right = dfs(root1.right, root2.right);
        return root;
    }
*/


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
