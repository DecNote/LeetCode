package leethot;


import java.util.Stack;

/**
 * @author : Dec
 * @date : 2021/6/12 14:12
 * <p>
 * 中序遍历，并保存之前的节点值
 * 两种思路：递归和迭代
 */
public class LeetCode98 {


    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }



    public boolean inOrder(TreeNode root) {
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val > pre) {
                pre = root.val;
            } else {
                return false;
            }
            root = root.right;
        }
        return true;
    }



    private long pre = Long.MIN_VALUE;

    public boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!dfs(root.left)) {
            return false;
        }

        if (pre >= root.val) {
            return false;
        }
        pre = root.val;

        return dfs(root.right);
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
