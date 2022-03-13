package record.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Dec
 * @date : 2021/9/8 15:48
 */
public class LeetCode279 {

    @Test
    public void test() {
        System.out.println(numSquares(13));
    }


    public int numSquares(int n) {

        int[] weight = new int[(int) Math.ceil(Math.sqrt(n))];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = (i + 1) * (i + 1);
        }
        int bagSize = n;
        int[] dp = new int[bagSize + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j < bagSize + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - weight[i]] + 1);
            }
        }
        return dp[bagSize];
    }

}
