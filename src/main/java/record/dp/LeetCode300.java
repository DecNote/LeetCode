package record.dp;

/**
 * @author : Dec
 * @date : 2021/9/11 10:33
 * <p>
 * 易错题
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        // dp[i]表示以nums[i]结尾的最长子序列的长度【必须这样设定】
        int[] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }

    /**
     * 错误示例
     */
    public int lengthOfLISError(int[] nums) {
        // dp[i]表示前i个数中，最长的递增子序列长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1];
            if (i == nums.length - 1) {

                System.out.println();
            }
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }
}
