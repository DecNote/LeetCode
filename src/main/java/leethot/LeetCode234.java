package leethot;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author : Dec
 * @date : 2021/7/19 17:23
 * <p>
 * 链表回文子串判断
 */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        LinkedList<Integer> list = new LinkedList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        while (list.size() >= 2) {
            if (!list.removeLast().equals(list.removeFirst())) {
                return false;
            }
        }
        return true;
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
