package offer;

import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 若递归深度过大，就会导致栈溢出
 * 2. 直接计算
 */
public class LeetCode10_1 {


    @Test
    public void test() {
        System.out.println(fib(5));
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
