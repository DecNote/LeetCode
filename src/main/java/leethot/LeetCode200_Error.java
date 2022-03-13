package leethot;

/**
 * @author : Dec
 * @date : 2021/7/13 18:52
 * <p>
 * 错误示例
 */
public class LeetCode200_Error {
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.flag = new boolean[grid.length][grid[0].length];

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && flag[i][j] == false) {
                    dfs(i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private boolean[][] flag;
    private char[][] grid;

    public void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= flag.length || y >= flag[0].length) {
            return;
        }

        // 【flag更新应该在flag判断完成后再进行】
        flag[x][y] = true;

        if (grid[x][y] == '0' || flag[x][y]) {
            return;
        }

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}
