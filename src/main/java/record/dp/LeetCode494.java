package record.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Dec
 * @date : 2021/9/8 13:59
 */
public class LeetCode494 {
    @Test
    public void test() {

//        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
//        int target = 1;
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;


        findTargetSumWays(nums, target);
        System.out.println();
        System.out.println(findTargetSumWaysBag(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        // 已知：leftSetSum - rightSetSum = target
        // 已知：leftSetSum + rightSetSum = sum
        // 可得：leftSetSum = (target + sum) / 2;

        // 问题变成了：从nums数组中选一些数，让其和为leftSetSum
        // dp[i][j]：从下标范围为0~i中进行选择，装满容量为j的背包，总共有dp[i][j]种方案
        // dp[j]：装满容量为j的背包，总共有dp[j]种方案

        // dp[i][j] = dp[i-1][j] + dp[i-1][j-weight[i]]


        int sum = Arrays.stream(nums).reduce(0, Integer::sum);
        if ((target + sum) % 2 == 1 || target > sum) {
            return 0;
        }
        if (target < 0) {
            target = -target;
        }

        int bagSize = (target + sum) / 2;
        int[] weight = nums;
        int n = nums.length;

        int[][] dp = new int[n + 1][bagSize + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }


        show(dp);


        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j <= bagSize; j++) {
                // 能放下当前物品情况下
                if (j >= weight[i - 1]) {
                    // 容量为j时：dp[i][j] = 放当前物品方法数 + 不放当前物品方法数
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - weight[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println();
        show(dp);
        return dp[n][bagSize];
    }


    /**
     * 一维DP
     */
    public int findTargetSumWaysBag(int[] nums, int target) {
        // left + right = sum
        // abs(left-right) = target
        // left = (-+)(sum+target)/2
        int sum = Arrays.stream(nums).reduce(0, (o1, o2) -> o1 + o2);
        // 先把target转为正数
        if (target < 0) {
            target = -target;
        }
        // 注意%的优先级
        if ((sum + target) % 2 == 1) {
            return 0;
        }

        int bagSize = sum + target / 2;

        // dp[j]表示，装满容量为j的背包的方法种数
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        int[] weight = nums;
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = dp[j] + dp[j - weight[i]];
            }
        }
        return dp[bagSize];
    }


    public void show(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
