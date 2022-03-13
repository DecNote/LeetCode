package offer;


import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 交替双指针
 * 2. 类似于追及问题，有一定技巧性
 */
public class LeetCode52_Tag {

    @Test
    public void test() {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        // 这里的公共节点指的是节点而不是节点值
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
