package record.dp;

/**
 * @author : Dec
 * @date : 2021/9/8 17:07
 *
 * 求最长公共子数组（连续子数组）
 */
public class LeetCode718 {
    public int findLength(int[] nums1, int[] nums2) {
        // 设dp[i][j]表示以nums1[i-1]和nums2[j-1] 结尾 的最长公共子数组长度
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
