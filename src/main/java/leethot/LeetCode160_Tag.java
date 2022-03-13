package leethot;

/**
 * @author : Dec
 * @date : 2021/7/13 17:13
 * <p>
 * 双指针法
 */
public class LeetCode160_Tag {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        // 退出时，p和q可能都为空
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
            // 典型错误：此时退出时p和q都不可能为空
            // p = p.next == null ? headB : p.next;
            // q = q.next == null ? headA : q.next;
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
