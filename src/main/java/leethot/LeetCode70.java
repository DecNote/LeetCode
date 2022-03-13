package leethot;

/**
 * @author : Dec
 * @date : 2021/6/10 23:33
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        // dp[i]表示爬到第n阶有多少种方法
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
