package offer;

import org.junit.Test;

import java.util.LinkedList;


/**
 * @author Dec
 * 1. 问题：合法出栈判断
 * 2. 模拟栈
 * 3. 基础题，多练习几遍
 */
public class LeetCode31_Tag {

    @Test
    public void test() {
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int idx = 0;
        // 用入栈数组作为for循环，而不是出栈数组
        for (int i = 0; i < pushed.length; i++) {
            stack.addLast(pushed[i]);
            while (!stack.isEmpty() && idx < popped.length && popped[idx] == stack.getLast()) {
                stack.removeLast();
                idx++;
            }
        }
        return stack.isEmpty();
    }
}
