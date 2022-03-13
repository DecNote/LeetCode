package record.dp;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/9/8 17:14
 * <p>
 * 回看1035题：和此题一模一样
 *
 * <p>
 * 对比：
 * 718题：两个数组的最长公共子序列（连续子序列）       -> dp设为以i，j结尾的最长公共子序列
 * 1143题：两个字符串的最长公共子序列（不连续子序列）   -> dp设为前i，j的最长公共子序列
 */
public class LeetCode1143 {


    @Test
    public void test() {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j]表示字符text1[0 ~ i-1] 和 text2[0 ~ j-1]的最长公共子序列，并不是表示以...结尾
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
