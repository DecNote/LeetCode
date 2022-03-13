package offer;

import org.junit.Test;

import java.util.LinkedList;


/**
 * @author Dec
 * 1. 二叉树镜像问题
 * 2. 递归
 * 3. 答案改编自 dfs先序遍历
 */
public class LeetCode27_Tag {


    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root = mirrorTree(root);
        layerOder(root);
    }

    private TreeNode parent = null;

    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }


    /**
     * 先序遍历
     *
     * @param root
     */
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 在先序遍历中交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 层次遍历，打印输出用
     *
     * @param root
     */
    public void layerOder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
