package leethot;

import java.util.LinkedList;

/**
 * @author : Dec
 * @date : 2021/7/13 17:00
 * <p>
 * 错误演示
 */
public class LeetCode155_Error {

}

class MinStack {

    private LinkedList<Integer> stack = new LinkedList<>();

    // 栈顶始终为最小元素
    private LinkedList<Integer> st = new LinkedList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int val) {
        stack.push(val);
        while (!st.isEmpty() && st.getLast() > val) {
            st.removeLast();
        }
        st.addLast(val);
    }

    public void pop() {
        int val = stack.removeLast();
        if (st.getLast() == val) {
            st.removeLast();
        }
    }

    public int top() {
        return stack.getLast();

    }

    public int getMin() {
        return st.getLast();
    }
}