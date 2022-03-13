package leethot;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/7/15 12:20
 * <p>
 * 链表排序
 */
public class LeetCode148 {
    @Test
    public void test() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode res = mergeSort(head);

        ListNode p = res;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        // fast指针的起点必须是head.next
        ListNode fast = head.next;

//        do {
//            if (fast.next == null) {
//                break;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        } while (fast != null);

        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }


        /**
         * 只有两个节点，当循环结束时：
         * fast = null
         * slow = 第2个节点
         * temp = null
         * -> merge失败
         */
        ListNode temp = slow.next;
        slow.next = null;
        ListNode p = mergeSort(head);
        ListNode q = mergeSort(temp);
        ListNode res = merge(p, q);
        return res;
    }

    public ListNode merge(ListNode p, ListNode q) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while (p != null && q != null) {
            if (p.val > q.val) {
                curr.next = q;
                curr = q;
                q = q.next;
            } else {
                curr.next = p;
                curr = p;
                p = p.next;
            }
        }

        if (p != null) {
            curr.next = p;
        }
        if (q != null) {
            curr.next = q;
        }
        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
