package offer;

import org.junit.Test;

import java.util.LinkedList;


/**
 * @author Dec
 * 1. 判断是不是二叉树镜像问题
 * 2. 【其实是在遍历两课二叉树，遍历的同时进行比较】
 * 3. 根节点左边为左子树，根节点右边为右子树，分别遍历并同时比较
 */
public class LeetCode28_Tag {


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        layerOder(root);
        System.out.println(isSymmetric(root));
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 根节点左边为左子树，根节点右边为右子树，分别遍历并同时比较
        return dfs(root.left, root.right);
    }

    /**
     * 同时遍历两棵树，左子树和右子树分开遍历
     *
     * @param leftRoot  左子树
     * @param rightRoot 右子树
     * @return
     */
    boolean dfs(TreeNode leftRoot, TreeNode rightRoot) {
        // 都为空，返回true
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        // 其中一个为空（必须有一个为null），返回false
        if (leftRoot == null || rightRoot == null) {
            return false;
        }
        // 值不同，返回false
        if (leftRoot.val != rightRoot.val) {
            return false;
        }
        // 递归
        return dfs(leftRoot.left, rightRoot.right) && dfs(leftRoot.right, rightRoot.left);
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
