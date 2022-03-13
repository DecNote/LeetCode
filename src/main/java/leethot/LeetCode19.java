package leethot;

/**
 * @author : Dec
 * @date : 2021/6/5 14:10
 * <p>
 * 1. 先找出倒数第n+1个节点
 * 2. 增加一个头节点有利于解题
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;

        int p = 0;
        int q = 1;
        ListNode pNode = root;
        ListNode qNode = head;
        while (qNode != null) {
            if (q - p == n + 1) {
                p++;
                pNode = pNode.next;
            }
            qNode = qNode.next;
            q++;
        }
        pNode.next = pNode.next.next;
        return root.next;
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
