package leethot;

/**
 * @author : Dec
 * @date : 2021/6/16 10:16
 * <p>
 * dfs方法
 */
public class LeetCode200 {


    public int numIslands(char[][] grid) {
        int res = 0;
        this.grid = grid;
        this.flag = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !flag[i][j]) {
                    dfs(i, j);
                    res++;
                }
            }
        }
        return res;
    }


    private char[][] grid;
    private boolean[][] flag;

    public void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (flag[x][y]) {
            return;
        }
        if (grid[x][y] == '0') {
            flag[x][y] = true;
            return;
        }


        flag[x][y] = true;


        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }
}
