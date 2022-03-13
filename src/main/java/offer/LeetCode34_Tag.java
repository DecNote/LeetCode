package offer;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


/**
 * @author Dec
 * <p>
 * 1. 重复问题
 */
public class LeetCode34_Tag {

    @Test
    public void test() {
    }

    private int target;
    private LinkedList<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;
//        dfsError(root, 0);

        if (root == null) {
            return new LinkedList<>();
        }
        temp.add(root.val);
        dfs(root, root.val);
        return this.res;
    }


    /**
     * 错误示例
     *
     * @param root
     * @param sum
     */
    public void dfsError(TreeNode root, int sum) {
        // 当节点A为叶子节点，将两次进入退出条件
        // 因为A.left = null 且 B.right = null
        // 这将导致答案重复
        if (root == null) {
            if (sum == this.target) {
                res.add(new LinkedList<>(temp));
            }
            return;
        }


        temp.add(root.val);
        dfsError(root.left, sum + root.val);
        temp.removeLast();

        temp.add(root.val);
        dfsError(root.right, sum + root.val);
        temp.removeLast();
    }


    /**
     * sum表示当前和，参数root表示的节点已加入sum中
     *
     * @param root
     * @param sum
     */

    public void dfs(TreeNode root, int sum) {
        // 当前节点是叶子节点
        if (root.left == null && root.right == null) {
            if (sum == this.target) {
                res.add(new LinkedList<>(temp));
            }
            return;
        }


        // 判断用于保证dfs的参数root一定为非空
        if (root.left != null) {
            temp.add(root.left.val);
            dfs(root.left, sum + root.left.val);
            temp.removeLast();
        }

        // 判断用于保证dfs的参数root一定为非空
        if (root.right != null) {
            temp.add(root.right.val);
            dfs(root.right, sum + root.right.val);
            temp.removeLast();
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
