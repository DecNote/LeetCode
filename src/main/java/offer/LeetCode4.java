package offer;


/**
 * @author Dec
 * <p>
 * 1. 应该从 右上->左下 对角线处开始查找，这样位置参量才可以一个加，一个减
 * 2. 从 左上->右下 对角线的话，位置参量会不知道往哪里移动
 * 3. 完善初始判断
 */
public class LeetCode4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
