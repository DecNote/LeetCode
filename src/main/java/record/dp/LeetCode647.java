package record.dp;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/9/8 22:04
 * <p>
 * 注意遍历顺序
 * <p>
 * leetcode-master/0647.回文子串.md at master · youngyangyang04/leetcode-master · GitHub
 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0647.%E5%9B%9E%E6%96%87%E5%AD%90%E4%B8%B2.md
 * <p>
 * 正常情况下，遍历是从 左上 -> 右下，这里应该改为 左下 -> 右上
 * <p>
 * 回看516
 */
public class LeetCode647 {
    @Test
    public void test() {
        System.out.println(countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        // 表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            // 注意j的起点
            for (int j = i; j < n; j++) {
                // 相等
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 不相等
                    if (i == j) {
                        dp[i][j] = true;
                    } else if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        // dp[i][j]的计算用到了还没算的dp[i + 1][j - 1]
                        // (i+1,j-1)在(i,j)的左下角
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 错误示例
     */
    public int countSubstringsError(String s) {
        int res = 0;
        int n = s.length();
        // 表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            // 注意j的起点
            for (int j = i; j < n; j++) {
                // 相等
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 不相等
                    if (i == j) {
                        dp[i][j] = true;
                    } else if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        // dp[i][j]的计算用到了还没算的dp[i + 1][j - 1]
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
