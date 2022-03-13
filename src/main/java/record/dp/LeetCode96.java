package record.dp;

/**
 * @author : Dec
 * @date : 2021/9/6 21:59
 *
 * 不同二叉树的个数：找规律题，用DP
 */
public class LeetCode96 {
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        // 注意dp[0]=1
        dp[0] = 1;
        dp[1] = 1;

        // i表示当前节点个数
        for (int i = 2; i <= n; i++) {
            // j表示根节点的左子树的节点个数
            for (int j = 0; j <= i-1; j++) {
                dp[i] += dp[j] * dp[i-j - 1];
            }
        }
        return dp[n];
    }
}
