package offer;

import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 如何记住已经走过的位置？   --->   在自身做标记，然后再改回来
 * 2. 递归思想
 */
public class LeetCode12_Tag {


    @Test
    public void test() {

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
//        char[][] board = {{'a', 'b'}, {'c', 'd'}};
//        String word = "abcd";
//
//        char[][] board = {{'a'}};
//        String word = "a";

        System.out.println(exist(board, word));
    }


    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {


        this.board = board;
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (judge(0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * @param pos 下一个待比较的字符word[pos]，即已经的找到相同的字符个数
     * @param i   位置
     * @param j   位置
     * @return
     */
    public boolean judge(int pos, int i, int j) {

        // 判断是否完成查找【这个判断条件要放在最前面】
        if (pos == word.length()) {
            return true;
        }

        // 判断是否越界
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        // 判断是否已经走过【这一步可以不判断，因为肯定和字符word[pos]不相等】
        if (board[i][j] == '\u0000') {
            return false;
        }

        // 未完成查找：判断字符是否相等
        if (board[i][j] != word.charAt(pos)) {
            return false;
        }

        // 未完成查找：字符相等，继续递归
        char backup = board[i][j];
        board[i][j] = '\u0000';

/*
        boolean flag1 = judge(pos + 1, i + 1, j);
        boolean flag2 = judge(pos + 1, i - 1, j);
        boolean flag3 = judge(pos + 1, i, j + 1);
        boolean flag4 = judge(pos + 1, i, j - 1);
        board[i][j] = backup;
        return flag1 || flag2 || flag3 || flag4;
*/

        // 只要有一个返回true，那么后面不会执行（剪枝），这比上面的注释方案要好
        boolean res = judge(pos + 1, i + 1, j) || judge(pos + 1, i - 1, j) || judge(pos + 1, i, j - 1) || judge(pos + 1, i, j + 1);
        board[i][j] = backup;
        return res;
    }
}
