package record.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Dec
 * @date : 2021/9/7 13:28
 * <p>
 * 螺旋矩阵
 */
public class LeetCode59_2_Tag {
    @Test
    public void test() {
        matrix(3);

        int[][] res = generateMatrix(4);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

    }

    public void matrix(int n) {
        int x, y;

        /**
         * for循环表示从最外层开始往里剥壳，circleLen每层壳的边长，注意circleLen每次减2
         */

        int pos = 0;
        for (int circleLen = n; circleLen > 0; circleLen = circleLen - 2) {
            x = pos;
            y = pos;
            pos++;

            // 最后一个正方形壳边长为1，则特殊处理
            if (circleLen == 1) {
                System.out.println(x + " " + y);
                break;
            }

            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    for (int j = 0; j < circleLen - 1; j++) {
                        System.out.println(x + " " + y);
                        y++;
                    }
                }
                if (i == 1) {
                    for (int j = 0; j < circleLen - 1; j++) {
                        System.out.println(x + " " + y);
                        x++;
                    }
                }
                if (i == 2) {
                    for (int j = 0; j < circleLen - 1; j++) {
                        System.out.println(x + " " + y);
                        y--;
                    }
                }
                if (i == 3) {
                    for (int j = 0; j < circleLen - 1; j++) {
                        System.out.println(x + " " + y);
                        x--;
                    }
                }
            }
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 0;
        int x, y;


        /**
         * for循环表示从最外层开始往里剥壳，circleLen每层壳的边长
         */

        int pos = 0;
        for (int circleLen = n; circleLen > 0; circleLen = circleLen - 2) {
            x = pos;
            y = pos;
            pos++;

            // 最后一个正方形壳边长为1，则特殊处理
            if (circleLen == 1) {
                res[x][y] = ++num;
                break;
            }

            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    for (int j = 0; j < circleLen - 1; j++) {
                        res[x][y] = ++num;
                        y++;
                    }
                }
                if (i == 1) {
                    for (int j = 0; j < circleLen - 1; j++) {
                        res[x][y] = ++num;
                        x++;
                    }
                }
                if (i == 2) {
                    for (int j = 0; j < circleLen - 1; j++) {
                        res[x][y] = ++num;
                        y--;
                    }
                }
                if (i == 3) {
                    for (int j = 0; j < circleLen - 1; j++) {
                        res[x][y] = ++num;
                        x--;
                    }
                }
            }
        }
        return res;
    }

}
