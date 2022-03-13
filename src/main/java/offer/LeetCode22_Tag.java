package offer;

import org.junit.Test;

import java.util.LinkedList;


/**
 * @author Dec
 * 1. 双指针法：保存链表序号值时也要同时保存指针指向该节点
 * 2. 定长队列法
 * 2. 【【易错题】】
 */
public class LeetCode22_Tag {


    @Test
    public void test() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode res = getKthFromEndV3(root, 2);
        printList(res);
    }

    /**
     * 双指针法
     */
    public ListNode getKthFromEndV3(ListNode head, int k) {
        int p = 0;
        ListNode pNode = head;
        int q = 0;
        ListNode qNode = head;

        while (qNode != null) {
            if (q - p == k) {
                p++;
                pNode = pNode.next;
            }
            q++;
            qNode = qNode.next;
        }

        return pNode;
    }


    /**
     * 典型错误示例：链表情况，双指针对应的节点也要声明！！！
     */
    public ListNode getKthFromEndV2(ListNode head, int k) {

        ListNode res = head;
        int p = 0;
        int q = 0;

        while (head != null) {
            if (q - p > k - 1) {
                p++;
                res = head;
            }
            q++;
            head = head.next;
        }
        return res;
    }

    public ListNode getKthFromEndV1(ListNode head, int k) {
        LinkedList<ListNode> queue = new LinkedList<>();

        while (head != null) {
            queue.add(head);
            if (queue.size() > k) {
                queue.removeFirst();
            }
            head = head.next;
        }
        return queue.getFirst();
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
