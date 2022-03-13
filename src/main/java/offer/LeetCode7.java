package offer;

import org.junit.Test;



/**
 * @author Dec
 * <p>
 * 1. 寻找根节点在中序中的位置
 */
public class LeetCode7 {


    @Test
    public void test() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        dfs(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rebuild(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode rebuild(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        if (preL > preR) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preL]);


        // rootPosInorder：寻找根节点在中序遍历中的位置
        int rootPosInorder = inL;
        while (rootPosInorder <= inR) {
            if (inorder[rootPosInorder] == root.val) {
                break;
            }
            rootPosInorder++;
        }

        // 左孩子个数计算
        int leftTreeNodeCount = rootPosInorder - inL;
        root.left = rebuild(preorder, inorder, preL + 1, preL + leftTreeNodeCount, inL, rootPosInorder - 1);
        root.right = rebuild(preorder, inorder, preL + leftTreeNodeCount + 1, preR, rootPosInorder + 1, inR);
        return root;
    }


    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
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
