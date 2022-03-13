package leethot;

/**
 * @author : Dec
 * @date : 2021/7/5 15:58
 */
public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private int[] preorder;
    private int[] inorder;

    public TreeNode build(int preL, int preR, int inL, int inR) {
        if (preL > preR) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preL]);

        // 根节点在中序的位置
        int pos = inL;
        for (int i = inL; i <= inR; i++) {
            if (root.val == inorder[i]) {
                pos = i;
                break;
            }
        }

        // 左子树节点个数
        int leftTreeNum = pos - inL;

        root.left = build(preL + 1, preL + leftTreeNum, inL, pos - 1);
        root.right = build(preL + leftTreeNum + 1, preR, pos + 1, inR);
        return root;
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
