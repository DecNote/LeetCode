package offer;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * @author Dec
 * <p>
 * 1. 二叉搜索从大到小打印
 * 2. 参数更新应该在return前
 */
public class LeetCode54_Tag {

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthLargest(root, 1));
    }

    /**
     * 迭代法
     */
    public int kthLargestLeet(TreeNode root, int k) {
        int index = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            index++;
            if (index == k) {
                return root.val;
            }
            root = root.left;
        }
        // root left right
        // left root right
        // root right left -> left right root

        // right root left
        return 0;
    }


    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs1(root);
        return this.res;
    }

    private int k;
    // dfs1：count=1
    // dfs2：count=0
    private int count = 1;
    private int res;

    public void dfs1(TreeNode root) {


        if (root == null) {
            return;
        }
        dfs1(root.right);
        if (count == k) {
            this.res = root.val;
            // count 初值为1
            // 【count更新：即使在退出之前，也得更新count】
            count++;
            return;
        }
        // count更新
        count++;
        dfs1(root.left);
    }

    public void dfs2(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(root.right);
        // count 初值为1，return之前已经更新了count，不会引发问题
        count++;
        if (count == k) {
            this.res = root.val;
            return;
        }
        dfs2(root.left);
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
