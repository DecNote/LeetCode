package offer;

import org.junit.Test;


/**
 * @author Dec
 * 1. 合并排序列表问题
 * 2. 类似于双指针
 * 3. 细节较多，【多练习】
 * 4. 新建头节点
 */
public class LeetCode25 {


    @Test
    public void test() {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);


        ListNode root = mergeTwoListsV2(l1, null);
        printList(root);

    }

    public ListNode mergeTwoListsV1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null && l2 == null) {
            return head.next;
        }
        if (l2 != null) {
            while (l2 != null) {
                curr.next = l2;
                l2 = l2.next;

                // 这一步忘记更新了
                curr = curr.next;
            }
            return head.next;
        }

        while (l1 != null) {
            curr.next = l1;
            l1 = l1.next;

            // 这一步忘记更新了
            curr = curr.next;
        }
        return head.next;
    }


    /**
     * 推荐版本
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }


        // 这是方法1的简化处理
        curr.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void printList(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
}
