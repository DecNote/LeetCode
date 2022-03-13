package offer;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author Dec
 */
public class LeetCode29_Tag {


    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3,11}, {8, 9, 4,12}, {7, 6, 5,13}};
        spiralOrder(matrix);

    }


    private int[][] matrix;

    private int[] res;
    private int count = 0;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }


        this.matrix = matrix;
        this.res = new int[matrix.length * matrix[0].length];

        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;

        while (x1 <= x2 && y1 <= y2) {
            circle(x1, y1, x2, y2);
            x1++;
            y1++;
            x2--;
            y2--;
        }

//        System.out.println(Arrays.toString(this.res));
        return this.res;
    }

    /**
     * 打印外围一环的元素，(x1,y1)，(x2,y2)分别确定左上和右下的元素
     * 因此左下为(x2,y1),右上为(x1,y2);
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void circle(int x1, int y1, int x2, int y2) {
        // 一行或一列单独判断
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                res[count++] = matrix[x1][i];
//                System.out.println(matrix[x1][i]);
            }
            return;
        }
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                res[count++] = matrix[i][y1];
//                System.out.println(matrix[i][y1]);
            }
            return;
        }


        for (int i = y1; i <= y2; i++) {
            res[count++] = matrix[x1][i];
//            System.out.println(matrix[x1][i]);
        }
        for (int i = x1 + 1; i <= x2; i++) {
            res[count++] = matrix[i][y2];
//            System.out.println(matrix[i][y2]);
        }
        for (int i = y2 - 1; i >= y1; i--) {
            res[count++] = matrix[x2][i];
//            System.out.println(matrix[x2][i]);
        }
        for (int i = x2 - 1; i > x1; i--) {
            res[count++] = matrix[i][y1];
//            System.out.println(matrix[i][y1]);
        }
    }

}
