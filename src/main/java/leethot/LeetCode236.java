package leethot;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author : Dec
 * @date : 2021/7/19 18:59
 *
 * 最近公共父节点
 */
public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.target = p;
        dfs(root);
        ArrayList<TreeNode> pPath = new ArrayList<>(path);

        temp.clear();
        this.target = q;
        dfs(root);
        ArrayList<TreeNode> qPath = new ArrayList<>(path);

        TreeNode res = root;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) == qPath.get(i)) {
                res = pPath.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    private ArrayList<TreeNode> path;
    private TreeNode target;
    private LinkedList<TreeNode> temp = new LinkedList<>();

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root == target) {
            // 容易遗漏
            temp.add(root);
            path = new ArrayList<>(temp);
            return;
        }

        temp.addLast(root);
        dfs(root.left);
        dfs(root.right);
        temp.removeLast();
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
