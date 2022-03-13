package leethot;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : Dec
 * @date : 2021/7/6 12:07
 * <p>
 * 1. 迭代（非递归）的中序遍历
 */
public class LeetCode94_Tag {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();


        while (root != null || !stack.isEmpty()) {
            // 先找出所有左节点，并存入栈。循环退出时，root=null
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }

            root = stack.removeLast();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }




    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();


        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }


            root = stack.removeLast();
            res.add(root.val);
            root = root.right;
        }
        return res;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
