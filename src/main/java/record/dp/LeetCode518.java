package record.dp;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/9/8 14:42
 */
public class LeetCode518 {


    @Test
    public void test() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }

    public int change(int amount, int[] coins) {
        int bagSize = amount;
        int[] weight = coins;

        // dp[i]表示凑成金额i的方法数
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;

        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j < bagSize + 1; j++) {
                dp[j] = dp[j] + dp[j - weight[i]];
            }
        }

        return dp[bagSize];
    }


}
