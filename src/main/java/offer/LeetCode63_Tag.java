package offer;

import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 模拟题，可以用DP
 * 2. 核心： 今天卖出的最大利润 = 今天价 - 之前的最低价
 */
public class LeetCode63_Tag {

    @Test
    public void test() {
    }

    /**
     * DP解法
     */
    public int maxProfitLeet(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        // dp[i]表示前i天的最大利润
        // dp[i] = max(dp[i-1], (今天价)-(前i-1天最低价))
        int[] dp = new int[prices.length];
        dp[0] = -prices[0];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[prices.length - 1];
    }


    /**
     * 自己模拟的解法
     */
    public int maxProfitMy(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        int profit;
        for (int i = 0; i < prices.length; i++) {
            // 前i天的最低价
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // 前i天最最低价买入，今天卖出的利润
            profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

}
