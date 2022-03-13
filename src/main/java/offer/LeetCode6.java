package offer;

import java.util.LinkedList;

/**
 * @author Dec
 * <p>
 * 1. 栈
 */
public class LeetCode6 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        LinkedList<Integer> list = new LinkedList<Integer>();
        while (head != null) {
            list.addFirst(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
