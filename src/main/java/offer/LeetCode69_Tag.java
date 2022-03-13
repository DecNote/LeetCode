package offer;

import org.junit.Test;

import java.util.LinkedList;


/**
 * @author Dec
 * <p>
 * 1. 求出从root到target的路径
 */
public class LeetCode69_Tag {

    @Test
    public void test() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        lowestCommonAncestor(root, root.left.right.right, root.left.left);
//        dfs(root);
    }


    /**
     * 【容易理解版本】
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 寻找由root到target的路径
        getPath(root, p);
        LinkedList<TreeNode> pPath = new LinkedList<>(targetPath);
        tempPath.clear();
        targetPath.clear();
        getPath(root, q);
        LinkedList<TreeNode> qPath = new LinkedList<>(targetPath);
        for (TreeNode treeNode : qPath) {
            System.out.println(treeNode.val);
        }


        // 找到第一个不同的节点
        TreeNode res = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) != qPath.get(i)) {
                return pPath.get(i - 1);
            }
            res = pPath.get(i);
        }
        return res;
    }


    LinkedList<TreeNode> tempPath = new LinkedList<>();
    LinkedList<TreeNode> targetPath = new LinkedList<>();


    /**
     * 获取二叉树从root到target的路径：必须是先序遍历，先访问父节点
     */
    public void getPath(TreeNode root, TreeNode target) {
        if (root == null) {
            return;
        }
        tempPath.add(root);
        // 找到路径
        if (root == target) {
            targetPath = new LinkedList<>(tempPath);
            return;
        }
        getPath(root.left, target);
        getPath(root.right, target);
        tempPath.removeLast();
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        System.out.println(root.val);
        dfs(root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
