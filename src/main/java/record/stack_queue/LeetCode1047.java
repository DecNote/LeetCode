package record.stack_queue;

import org.junit.Test;

import java.util.Stack;

/**
 * @author : Dec
 * @date : 2021/9/5 17:39
 */
public class LeetCode1047 {


    @Test
    public void test() {
        System.out.println(removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder res = new StringBuilder();

        for (char c : stack) {
            res.append(c);
        }
        return res.toString();
    }
}
