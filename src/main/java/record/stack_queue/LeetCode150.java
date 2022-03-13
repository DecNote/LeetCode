package record.stack_queue;

import org.junit.Test;

import java.util.Stack;

/**
 * @author : Dec
 * @date : 2021/9/5 17:54
 */
public class LeetCode150 {
    @Test
    public void test() {
        String[] s = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(s));

    }


    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(tokens[i])) {
                int last = stack.pop();
                int pre = stack.pop();
                stack.push(pre - last);
            } else if ("*".equals(tokens[i])) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(tokens[i])) {
                int last = stack.pop();
                int pre = stack.pop();
                stack.push(pre / last);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
