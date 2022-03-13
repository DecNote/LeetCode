package leethot;

/**
 * @author : Dec
 * @date : 2021/6/10 23:14
 */
public class LeetCode62 {

    public int uniquePaths(int m, int n) {
        // dp[i][j]表示到达(i,j)有多少种路径
        // dp[i][j] = dp[i-1][j] + dp[i][j-1];
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
