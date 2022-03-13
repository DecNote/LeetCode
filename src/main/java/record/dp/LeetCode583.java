package record.dp;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/9/8 21:16
 */
public class LeetCode583 {

    @Test
    public void test() {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        // 换一种思路，其实就是在求最长公共子序列
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int step = word1.length() + word2.length() - dp[i][j] * 2;
                if (step < res) {
                    res = step;
                }
            }
        }
        return res;
    }
}
