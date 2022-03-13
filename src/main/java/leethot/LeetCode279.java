package leethot;

/**
 * @author : Dec
 * @date : 2021/6/17 20:09
 * <p>
 * 完全平方数
 * dp[0] = 0  -> 数字n刚好可以开平方时，需要用到dp[0]=0
 */
public class LeetCode279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (dp[i - j * j] + 1 < dp[i]) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }
        return dp[n];
    }
}
