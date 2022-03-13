package leethot;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author : Dec
 * @date : 2021/6/15 22:07
 *
 * 对比LeetCode剑指offer 30题
 */
public class LeetCode155_Tag {

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }


    class MinStack {


        private LinkedList<Integer> stack = new LinkedList<>();
        private LinkedList<Integer> assistStack = new LinkedList<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {


        }

        public void push(int val) {
            stack.addLast(val);
            if (assistStack.isEmpty()) {
                assistStack.addLast(val);
            } else {
                assistStack.addLast(Math.min(assistStack.getLast(), val));
            }
        }

        public void pop() {
            stack.removeLast();
            assistStack.removeLast();
        }

        public int top() {
            return stack.getLast();
        }

        public int getMin() {
            return assistStack.getLast();
        }
    }
}
