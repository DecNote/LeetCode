package leethot;

/**
 * @author : Dec
 * @date : 2021/6/11 13:56
 */
public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    private char[][] board;
    private String word;


    public boolean dfs(int x, int y, int p) {
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0) {
            return false;
        }

        if (board[x][y] == '\u0000') {
            return false;
        }

        if (board[x][y] != word.charAt(p)) {
            return false;
        }

        if (p == word.length() - 1) {
            return true;
        }

        char c = board[x][y];
        board[x][y] = '\u0000';
        boolean flag = dfs(x + 1, y, p + 1) || dfs(x - 1, y, p + 1) || dfs(x, y - 1, p + 1) || dfs(x, y + 1, p + 1);
        board[x][y] = c;
        return flag;
    }
}
