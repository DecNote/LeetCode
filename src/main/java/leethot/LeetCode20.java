package leethot;

import java.util.LinkedList;

/**
 * @author : Dec
 * @date : 2021/7/1 17:06
 *
 * 1. 用栈来模拟
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);


            if (!stack.isEmpty() && ch == ')' && stack.getLast() == '(') {
                stack.removeLast();
                continue;
            }
            if (!stack.isEmpty() && ch == ']' && stack.getLast() == '[') {
                stack.removeLast();
                continue;
            }
            if (!stack.isEmpty() && ch == '}' && stack.getLast() == '{') {
                stack.removeLast();
                continue;
            }
            stack.add(ch);
        }
        return stack.isEmpty();
    }
}
