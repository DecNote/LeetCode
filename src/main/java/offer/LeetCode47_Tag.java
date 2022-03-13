package offer;


import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. DP思想
 * 2. 假定grid为(m,n)矩阵，那么dp矩阵最好是(m+1,n+1)，不然初始化会很麻烦，且两层的for循环也很麻烦
 * 3. 二维矩阵初始化，建议采用上面这种方式
 */
public class LeetCode47_Tag {

    @Test
    public void test() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue(grid));

    }

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // dp[i][j]表示以格子grid[i-1][j-1]为终点的价值
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[i][j] = Math.max(grid[i - 1][j - 1] + dp[i - 1][j], grid[i - 1][j - 1] + dp[i][j - 1]);
            }
        }
        return dp[grid.length][grid[0].length];
    }

}
