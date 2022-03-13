package offer;

import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 模拟题，多练练
 * 2. 【典型错误示例】：计算数位和时，条件写成了 temp % 10 != 0
 */
public class LeetCode13_Tag {


    @Test
    public void test() {
        System.out.println(movingCount(38, 15, 9));

    }

    private boolean[][] flag;
    private int k;

    private int res = 0;

    public int movingCount(int m, int n, int k) {
        this.flag = new boolean[m][n];
        this.k = k;

        dfs(0, 0);
        return this.res;
    }


    public void dfs(int i, int j) {
        // 越界判断
        if (i < 0 || i >= flag.length || j < 0 || j >= flag[0].length) {
            return;
        }

        // 已访问判断
        if (this.flag[i][j]) {
            return;
        }

        // 访问当前位，先标记已经访问
        this.flag[i][j] = true;


        // 计算数位和判断
        int sum = 0;
        int temp = i;
        while (temp != 0) {
            sum += temp % 10;
            temp = temp / 10;
        }
        temp = j;
        while (temp != 0) {
            sum += temp % 10;
            temp = temp / 10;
        }


        // 数位和不符合要求，返回
        if (sum > k) {
            return;
        }

        // 符合要求，继续递归
        this.res++;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}
