package offer;

import org.junit.Test;


/**
 * @author Dec
 * 1. 新建头节点，但不存储值
 */
public class LeetCode18 {


    @Test
    public void test() {
    }

    public ListNode deleteNode(ListNode head, int val) {

        // 新建头节点，值为空，指向head
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode last = newHead;

        while (head != null && head.val != val) {
            last = head;
            head = head.next;
        }

        if (head != null) {
            last.next = head.next;
        }
        return newHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
