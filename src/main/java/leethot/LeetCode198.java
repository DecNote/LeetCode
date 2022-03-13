package leethot;

/**
 * @author : Dec
 * @date : 2021/6/15 23:25
 *
 * 易错题
 */
public class LeetCode198 {


    /**
     * 易错点：认为dp[n-1]就是结果
     */
    public int rob(int[] nums) {
        // dp[i]:偷窃前i家，且必偷第i家的最大金额
        // dp[i] = max(dp[0 ~ i-1] + nums[i], nums[i])

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            for (int j = 0; j < i - 1; j++) {
                if (dp[j] + nums[i] > dp[i]) {
                    dp[i] = dp[j] + nums[i];
                }
            }
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }


    public int robLeet(int[] nums) {
        // dp[i]表示偷前i家的最大金额
        // dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        // max(偷第i家，不偷第i家)

        // 思维定势在dp[i]表示偷第i家的最大金额

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 【易错点】 dp[1]容易直接初始化为nums[1]
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        }
        return dp[nums.length - 1];
    }

}
