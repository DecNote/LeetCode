package record.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Dec
 * @date : 2021/9/5 19:39
 * <p>
 * 两个队列来模拟栈
 * <p>
 * leetcode-master/0225.用队列实现栈.md at master · youngyangyang04/leetcode-master · GitHub
 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0225.%E7%94%A8%E9%98%9F%E5%88%97%E5%AE%9E%E7%8E%B0%E6%A0%88.md
 */
public class LeetCode225 {
    /**
     * 用两个队列实习
     */
    class MyStack1 {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();

        public MyStack1() {
        }

        public void push(int x) {
            q1.addLast(x);
        }

        public int pop() {
            while (q1.size() > 1) {
                q2.addLast(q1.removeFirst());
            }
            int res = q1.removeFirst();
            while (!q2.isEmpty()) {
                q1.addLast(q2.removeFirst());
            }
            return res;
        }

        public int top() {
            while (q1.size() > 1) {
                q2.addLast(q1.removeFirst());
            }
            int res = q1.removeFirst();
            while (!q2.isEmpty()) {
                q1.addLast(q2.removeFirst());
            }
            q1.addLast(res);
            return res;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }


    /**
     * 用1个队列实习
     */
    class MyStack2 {
        LinkedList<Integer> queue = new LinkedList<>();

        public MyStack2() {
        }

        public void push(int x) {
            queue.addLast(x);
        }

        public int pop() {
            int n = queue.size() - 1;
            for (int i = 0; i < n; i++) {
                queue.addLast(queue.removeFirst());
            }
            return queue.removeFirst();
        }

        public int top() {
            int n = queue.size() - 1;
            for (int i = 0; i < n; i++) {
                queue.addLast(queue.removeFirst());
            }
            int res = queue.removeFirst();
            queue.addLast(res);
            return res;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
