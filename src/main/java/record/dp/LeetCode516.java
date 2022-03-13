package record.dp;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/9/8 22:05
 * <p>
 * 回看647
 */
public class LeetCode516 {

    @Test
    public void test() {
        System.out.println(longestPalindromeSubseq("cbbd"));
    }

    public int longestPalindromeSubseq(String s) {
        int res = 0;
        int n = s.length();

        // dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
        int[][] dp = new int[n][n];
        // 初始化
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 1;
            }
        }


        for (int i = n - 1; i >= 0; i--) {
            // 注意j的起点
            for (int j = i; j < n; j++) {
                // 相等
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (j - i == 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    // 不相等【更新公式】
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                if (res < dp[i][j]) {
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
}
