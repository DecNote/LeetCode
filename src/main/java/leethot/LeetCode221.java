package leethot;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/6/17 9:28
 * <p>
 * 技巧题
 */
public class LeetCode221 {


    @Test
    public void test() {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix));


    }

    public int maximalSquare(char[][] matrix) {

        // dp[i][j]表示以matrix[i][j]为矩形右下角的最大边长
        // dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])

        int res = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                if (dp[i][j] > res) {
                    res = dp[i][j];
                }
            }

        }
        return res * res;
    }

}
