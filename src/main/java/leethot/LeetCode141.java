package leethot;


/**
 * @author : Dec
 * @date : 2021/6/12 21:17
 * <p>
 * 1. 链表没有环的标志：存在节点的next为null
 * 2. 链表有环的标志：存在节点的next为前面的节点
 * 3. 环形链表：快慢指针，起点相同，但遍历步长分布为1和2
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        do {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
        } while (slow != fast);
        return true;
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
