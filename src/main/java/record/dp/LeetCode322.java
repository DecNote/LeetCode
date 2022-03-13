package record.dp;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author : Dec
 * @date : 2021/9/8 15:28
 * <p>
 * DP -> 求最小，在第二个for循环中还要特殊处理，以及初始值也要注意
 */
public class LeetCode322 {


    @Test
    public void test() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }



    public int coinChange(int[] coins, int amount) {
        int bagSize = amount;
        int[] weight = coins;
        // dp[j]表示装满容量为j的背包， 最少 所需硬币个数
        int[] dp = new int[bagSize + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j < bagSize + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - weight[i]] + 1);
            }
        }
        return dp[bagSize] == 1000000 ? -1 : dp[bagSize];
    }


    public int coinChangeV2(int[] coins, int amount) {
        // dp[i]表示凑成金额i所需要的最少的硬币个数
        // dp[j] = min(dp[j], dp[j-weight[i]] + )
        int bagSize = amount;
        int[] weight = coins;
        int[] dp = new int[bagSize + 1];

        dp[0] = 0;
        for (int i = 0; i < bagSize; i++) {
            dp[i + 1] = Integer.MAX_VALUE;
        }


        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j < bagSize + 1; j++) {
                // dp[j - weight[i]]为最大值时，表示凑不到金额 j-weight[i]
                if (dp[j - weight[i]] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - weight[i]] + 1);
            }
        }
//        System.out.println(Arrays.toString(dp));
        if (dp[bagSize] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[bagSize];
        }
    }
}
