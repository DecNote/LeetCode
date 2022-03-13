package record.dp;

/**
 * @author : Dec
 * @date : 2021/9/6 21:08
 * dp[物品范围][背包容量]
 * <p> dp[i][j] = dp[i-1][j-物品i重量] + 物品i价值 , dp[i-1][j]
 * 注意dp的定义
 */
public class LeetCode343 {
    public int integerBreak(int n) {
        // dp[i]表示至少两个正整数的最大积
        // dp[i+1]= dp[i]*1, dp[i-1]*2, dp[i-2]*3,...,dp[2] * (i-1), dp[1] * (i)
        // dp[i] = dp[i-1]*1, dp[i-2]*2,..., dp[2]*(i-2), dp[1]*(i-1)

        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(j * (i - j), Math.max(dp[i], dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
