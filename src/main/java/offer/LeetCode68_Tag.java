package offer;

import org.junit.Test;

import java.util.LinkedList;


/**
 * @author Dec
 * <p>
 * 1. 求出从root到target的路径
 * 2. 非递归方法找路径容易遗漏目标节点
 */
public class LeetCode68_Tag {

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
        LinkedList<TreeNode> pPath = getBstPath(root, p);
        LinkedList<TreeNode> qPath = getBstPath(root, q);

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


    /**
     * 获取二叉搜索树从root到target的路径
     */
    public LinkedList<TreeNode> getBstPath(TreeNode root, TreeNode target) {
        LinkedList<TreeNode> path = new LinkedList<>();
        while (root != target) {
            path.add(root);
            if (root.val > target.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        path.add(target);
        return path;
    }


    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        System.out.println(root.val);
        dfs(root.right);
    }

    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // p和q都在root的右子树
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
                continue;
            }
            // p和q都在root的左子树
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
                continue;
            }
            // 情况1：p和q一个在root左子树，一个在root右子树，那么此时root就是最近公共父节点
            // 情况2：root == p && root.val > q, root == p && root.val < q
            // 情况3：root == q && root.val > p, root == q && root.val < p
            break;
        }

        return root;
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
