package record.dp;

import java.util.Arrays;

/**
 * @author : Dec
 * @date : 2021/9/7 17:22
 */
public class LeetCode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).reduce(0, Integer::sum);

        int n = stones.length;
        int bagSize = sum / 2;
        int[] weight = stones;
        int[] value = stones;

        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < n; i++) {
            for (int j = bagSize; j >= 0; j--) {
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return Math.abs(sum - dp[bagSize] - dp[bagSize]);
    }
}
