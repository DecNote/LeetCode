package offer;

import org.junit.Test;


/**
 * @author Dec
 * 1. 反转链表问题
 * 2. 涉及2个节点
 * 3. 【多练习此题】
 */
public class LeetCode24 {


    @Test
    public void test() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode res = reverseList(root);
        printList(res);
    }

    public ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//
//        ListNode last = null;
//        ListNode curr = head;
//        ListNode next = head.next;
//
//        while (curr != null) {
//            next = curr.next;
//            curr.next = last;
//            last = curr;
//            curr = next;
//        }
//        return last;

        if (head == null) {
            return null;
        }


        ListNode last = null;
        ListNode cur = head;
        ListNode temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = last;

            last = cur;
            cur = temp;
        }

        return last;
    }


    public void printList(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
