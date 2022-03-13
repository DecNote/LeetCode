package leethot;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Dec
 * @date : 2021/6/8 10:21
 *
 * 1. 记忆：矩阵顺时针选择90度 = 水平翻转+主对角线翻转
 * 2. 扩展：矩阵的转置 = 主对角线翻转
 * 3. 水平翻转和主对角线翻转容易写错！！！
 */
public class LeetCode48_Tag {

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateV2(matrix);
    }


    /**
     * 水平翻转+主对角线镜像
     *
     * @param matrix
     */
    public void rotateV2(int[][] matrix) {

        int n = matrix.length;
        int temp;

        show(matrix);

        // 水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
        show(matrix);

        // 主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        show(matrix);
    }


    /**
     * 辅助数组法
     */
    public void rotateV1(int[][] matrix) {
        int n = matrix.length;
        // 旋转：第i行 -> 倒数第i列
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = matrix[i][j];
            }
        }
        show(matrix);
        show(res);
    }


    public void show(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}
