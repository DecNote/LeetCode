package record.dp;

/**
 * @author : Dec
 * @date : 2021/9/8 15:18
 */
public class LeetCode377 {
    public int combinationSum4(int[] nums, int target) {
        int bagSize = target;
        int[] weight = nums;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;

        for (int j = 0; j < bagSize + 1; j++) {
            for (int i = 0; i < weight.length; i++) {
                if (j >= weight[i]) {
                    dp[j] = dp[j] + dp[j - weight[i]];
                }
            }
        }
        return dp[bagSize];
    }
}
