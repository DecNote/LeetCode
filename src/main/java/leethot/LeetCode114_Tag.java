package leethot;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : Dec
 * @date : 2021/6/11 14:51
 * <p>
 * 1. 树遍历过程要修改节点指向，那么可以将左右孩子先保存一份，再修改root指向
 * 2. 也可以使用迭代的思路
 */
public class LeetCode114_Tag {
    public void flatten(TreeNode root) {

        dfs(root);

    }


    private TreeNode preNode;

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode nodeLeft = root.left;
        TreeNode nodeRight = root.right;

        root.left = null;
        if (preNode == null) {
            preNode = root;
        } else {
            preNode.right = root;
            preNode = root;
        }

        dfs(nodeLeft);
        dfs(nodeRight);
    }


    public void preOrder(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();

        List<TreeNode> list = new ArrayList<>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                list.add(root);
                root = root.left;
            }
            while(root == null && !stack.isEmpty()) {
                root = stack.pop().right;
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
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
