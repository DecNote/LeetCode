package leethot;

/**
 * @author : Dec
 * @date : 2021/6/17 21:36
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        // dp[i]：以nums[i]结尾的最长子序列

        int [] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int res = 1;

        for(int i = 1; i < nums.length; i++) {
            // 往前找，找到第一个小于nums[i]的数 -> nums[j]
            // dp[i] = dp[j] + 1

            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
