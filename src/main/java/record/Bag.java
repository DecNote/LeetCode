package record;

/**
 * @author : Dec
 * @date : 2021/9/6 22:22
 * 速记：范围、容量、价值
 * <p>
 * * dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
 * * dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
 */
public class Bag {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        int res = bagDp2(weight, value, bagSize);
        System.out.println(res);

        res = bagDp1(weight, value, bagSize);
        System.out.println(res);
    }


    public static int bagDp1(int[] weight, int[] value, int bagSize) {
        // dp[j]表示容量为j的背包的最大价值
        int[] dp = new int[bagSize + 1];

        int n = weight.length;

        // 必须先遍历物品序号
        for (int i = 0; i < n; i++) {
            // 背包容量必须是倒序
            for (int j = bagSize; j >= 0; j--) {
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return dp[bagSize];
    }


    public static int bagDp2(int[] weight, int[] value, int bagSize) {
        int n = weight.length;
        int[][] dp = new int[n][bagSize + 1];
        // 初始化
        // 1. dp[*][0] = 0
        // 2. dp[0][*] = ?
        for (int i = 0; i <= bagSize; i++) {
            if (i >= weight[0]) {
                dp[0][i] = value[0];
            }
        }

        // 遍历开始
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][bagSize];
    }
}
