package leethot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Dec
 * @date : 2021/7/5 15:22
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        levelTravel(root);
        return res;

    }

    private List<List<Integer>> res = new LinkedList<>();


    public void levelTravel(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> temp = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.removeFirst();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
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
