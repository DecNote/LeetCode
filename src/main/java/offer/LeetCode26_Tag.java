package offer;

import org.junit.Test;


/**
 * @author Dec
 * 1. 子树判断【难题】
 * 2. 递归
 * 3. 思路：两步走，先找到A树中等于节点B的节点（递归遍历实现），再由此节点开始比较（递归遍历比较）
 */
public class LeetCode26_Tag {


    @Test
    public void test() {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);

        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);


        System.out.println(isSubStructure(A, B));

    }


    /**
     * isSubStructure其实也是一个树的递归遍历，用于查找A中和节点B相同的节点，然后再进行子树判断
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 判断 B树 是不是 以节点A为起点的 A的子树
        if (dfs(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 判断 B树 是不是 以节点A为起点的 A的子树
     */
    boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        // A=null 且 B!=null 情况
        if (A == null) {
            return false;
        }
        // A和B都不是null，且A!=B
        if (A.val != B.val) {
            return false;
        }
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }


    public class TreeNode {
        int val;
        LeetCode26_Tag.TreeNode left;
        LeetCode26_Tag.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
