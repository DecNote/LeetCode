package record.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Dec
 * @date : 2021/9/7 17:12
 *
 * 问题建模：从一个集合中选部分数来满足题目要求，即背包问题（weight = value）
 */
public class LeetCode416 {
    @Test
    public void test() {
        int[] nums = {8};
        System.out.println(canPartitionBag(nums));
    }


    public boolean canPartitionBag(int[] nums) {
        int sum = Arrays.stream(nums).reduce(0, Integer::sum);
        if (sum % 2 == 1) {
            return false;
        }
        // dp[j]表示能否从0~i个数中选出部分，使其最大和为j
        int[] weight = nums;
        int[] value = nums;
        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagSize] == bagSize;
    }

    public boolean canPartitionBoolean(int[] nums) {
        // dp[j]表示能否从0~i个数中选出部分，使其和为j
        int sum = Arrays.stream(nums).reduce(0, Integer::sum);
        if (sum % 2 == 1) {
            return false;
        }
        int bagSize = sum / 2;
        int[] weight = nums;
        boolean[] dp = new boolean[bagSize + 1];
        // 初始，除dp[0]，其他默认认为不能分割成两个元素和相等的子集
        dp[0] = true;
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = dp[j] || dp[j - weight[i]];
            }
        }
        return dp[bagSize];
    }

}
