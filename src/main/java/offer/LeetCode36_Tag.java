package offer;


import org.junit.Test;

/**
 * @author Dec
 * <p>
 * 1. 二叉搜索树的中序遍历问题：二叉搜索树原地转链表
 * 2. 转换成链表，那么就需要声明一个节点，保存当前到了链表中哪一个节点了
 * 3. 从链表的角度思考这题，left=pre, right=next，中序遍历结果就是这个链表，因此需要改链表中前一个节点的next(left)，和当前节点的pre(left)
 * 4. 问题就转化成了，如何保存链表中前一个节点
 */
public class LeetCode36_Tag {

    @Test
    public void test() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
//        Node head = treeToDoublyList(root);
        inOrder(root);


//        // 打印结果
//        Node curr = head;
//        while (curr.right != head) {
//            System.out.print(curr.val + " ");
//            curr = curr.right;
//        }
//        System.out.print(curr.val);
    }


    /**
     * pre表示在链表中的前一个节点
     */
    private Node pre;
    /**
     * head表示链表中的头节点
     */
    private Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 更新规则：left指向比自己小的节点，right指向比自己大的节点
     * curr表示链表中的节点，pre表示curr的前一个节点
     * 就curr和pre两个节点而言，他们需要修改的是：curr.left = pre;  pre.right = curr;
     *
     * @param curr
     */
    void dfs(Node curr) {
        if (curr == null) {
            return;
        }
        dfs(curr.left);

        // 第一个到这一步的，一定是二叉搜索树中的最小元素，因此在此之前pre没有被赋值过，为null
        if (pre != null) {
            pre.right = curr;
        } else {
            head = curr;
        }
        curr.left = pre;
        pre = curr;

        dfs(curr.right);
    }


    public void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {

            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
