package offer;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author Dec
 * <p>
 * 1. DP
 * 2. 如何设置DP公式表示含义，以及DP更新公式
 * 3. dp[i][j]表示投掷完第i个骰子，点数和为j出现的次数
 */
public class LeetCode60_Tag {

    @Test
    public void test() {
        System.out.println(Arrays.toString(dicesProbability(2)));
    }

    public double[] dicesProbability(int n) {
        // dp[i][j]表示投掷完第i个骰子，点数和为j出现的次数
        // 更新公式：dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] +...+ dp[i-1][j-6]
        // 更新公式理解：更新公式中6项相加，分别对应当前点数为1~6的情况
        int[][] dp = new int[n + 1][n * 6 + 1];

        // 第一枚骰子初始化
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        // dp[i][j]表示投掷完第i个骰子，点数和为j出现的次数
        for (int i = 2; i <= n; i++) {
            // j(点数和)的起点值为i，终点值为i*6
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    // j-k可能为负数
                    if (j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }
        // 点数和的可能范围是n~6n
        double[] res = new double[5 * n + 1];
        double divide = Math.pow(6, n);
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = dp[n][i] / divide;
        }
        return res;
    }

}
