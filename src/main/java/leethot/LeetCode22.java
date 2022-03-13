package leethot;

import org.junit.Test;

import java.util.*;

/**
 * @author : Dec
 * @date : 2021/6/5 18:59
 * <p>
 * 1. 合理的括号序列要求：在n对括号时，从左依次往右数，左括号的个数要始终大于等于右括号的个数
 * 2. dfs可以实现这一点
 */
public class LeetCode22 {

    @Test
    public void test() {
        List<String> res = generateParenthesis(4);
        System.out.println(res.size());
        System.out.println(res);
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs("", 0, 0);
        return res;
    }

    private List<String> res = new LinkedList<>();
    private int n;

    /**
     * @param s     当前字符串
     * @param left  左括号个数
     * @param right 右括号个数
     */
    public void dfs(String s, int left, int right) {
        if (left == n) {
            while (right < n) {
                s = s + ')';
                right++;
            }
            res.add(s);
            return;
        }

        if (left == right) {
            dfs(s + '(', left + 1, right);
        } else if (left > right && left < n) {
            dfs(s + '(', left + 1, right);
            dfs(s + ')', left, right + 1);
        }
    }
}
