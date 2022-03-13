package leethot;

import org.junit.Test;

/**
 * @author Dec
 * <p>
 * 1. 如何保存进位？
 * 2. 当到了节点尾部，还要判断前面是否还有进位没有加上
 * 3. 使用头节点
 */
public class LeetCode2 {


    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1, l2);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int high = 0;

        ListNode root = new ListNode(0);
        ListNode p = root;

        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + high;
            high = sum / 10;
            sum = sum % 10;
            p.next = new ListNode(sum);
            p = p.next;

            l1 = l1.next;
            l2 = l2.next;
        }



        while (l1 != null) {
            sum = l1.val + high;
            high = sum / 10;
            sum = sum % 10;
            p.next = new ListNode(sum);
            p = p.next;

            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + high;
            high = sum / 10;
            sum = sum % 10;
            p.next = new ListNode(sum);
            p = p.next;

            l2 = l2.next;
        }
        if (high != 0) {
            p.next = new ListNode(high);
        }
        return root.next;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
