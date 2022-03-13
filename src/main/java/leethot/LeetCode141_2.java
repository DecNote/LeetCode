package leethot;

import org.junit.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author : Dec
 * @date : 2021/6/12 23:07
 *
 * 1. 快慢指针法
 * 2. 哈希表法
 */
public class LeetCode141_2 {

    @Test
    public void test() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(detectCycle(head).val);

    }


    public ListNode detectCycleLeet(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        do {
            if (fast == null || fast.next == null) {
                return null;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        } while (slow != fast);


        // 上面循环跳出，说明有环，下面找入环节点
        // 规律：当slow和fast相遇时，再使用指针p指向头节点；随后，p和slow每次向后移动一个位置，最终它们会在入环点相遇
        // 上面的规律成立要求slow和fast最开始的起点相同
        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
            } else {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
