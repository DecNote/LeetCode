package offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * @author Dec
 * <p>
 * 1. 哈希表：键为原节点，值为新节点
 * 2. 键值对都保存Node，这一点很难想到
 */
public class LeetCode35_Tag {

    @Test
    public void test() {
    }


    /**
     * 推荐版本
     *
     * @param head
     * @return
     */
    public Node copyRandomListLeet(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();

        // 复制各个节点，简历 “原节点 -> 新节点” 的Map映射
        Node curr = head;
        while (curr != null) {
            // 旧节点为键，新节点为值，存入Map
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // 更新新节点的指向
        curr = head;
        while (curr != null) {
            Node node = map.get(curr);
            node.next = map.get(curr.next);
            node.random = map.get(curr.random);
            curr = curr.next;
        }


        return map.get(head);
    }


    /**
     * 维护一个有序List，来记住random的指向
     *
     * @param head
     * @return
     */
    public Node copyRandomListMy(Node head) {
        LinkedList<Node> oldList = new LinkedList<>();

        Node curr = head;
        while (curr != null) {
            oldList.add(curr);
            curr = curr.next;
        }


        LinkedList<Node> list = new LinkedList<>();

        Node newHead = new Node(0);
        Node last = newHead;
        for (int i = 0; i < oldList.size(); i++) {
            Node node = new Node(oldList.get(i).val);
            list.add(node);
            last.next = node;
            last = node;
        }

        for (int i = 0; i < oldList.size(); i++) {
            if (oldList.get(i).random == null) {
                list.get(i).random = null;
                continue;
            }
            int idx = oldList.indexOf(oldList.get(i).random);
            list.get(i).random = list.get(idx);
        }

        return newHead.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
