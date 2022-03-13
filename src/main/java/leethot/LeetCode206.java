package leethot;

/**
 * @author : Dec
 * @date : 2021/6/16 10:47
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode temp;

        while (curr != null) {
            temp = curr.next;

            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;

    }


    public class ListNode {
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
