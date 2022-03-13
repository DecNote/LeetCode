package offer;

import org.junit.Test;

import java.util.LinkedList;


/**
 * @author Dec
 * 1. 问题：可以获取最小元素的栈
 * 2. 思路：辅助栈
 */
public class LeetCode30_Tag {


    @Test
    public void test() {

    }

    class MinStack {

        private LinkedList<Integer> stack1 = new LinkedList<Integer>();
        private LinkedList<Integer> stack2 = new LinkedList<Integer>();


        public MinStack() {

        }

        public void push(int x) {
            stack1.addLast(x);
            // 注意使用大于等于号
            if (stack2.isEmpty() || stack2.getLast() >= x) {
                stack2.addLast(x);
            }
        }

        public void pop() {
            // 使用equals，不要使用==，否则会出错
            if (stack1.removeLast().equals(stack2.getLast())) {
                stack2.removeLast();
            }
        }

        public int top() {
            return stack1.getLast();
        }

        public int min() {
            return stack2.getLast();
        }
    }

}
