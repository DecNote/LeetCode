package leethot;

/**
 * @author : Dec
 * @date : 2021/7/5 17:06
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            if (res < prices[i] - minPrice) {
                res = prices[i] - minPrice;
            }
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
        }
        return res;

    }
}
