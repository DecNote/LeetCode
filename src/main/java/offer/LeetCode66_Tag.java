package offer;

import org.junit.Test;


/**
 * @author Dec
 * 1. 我的思路：分别计算前i项和后i项的积(i=1~n)
 */
public class LeetCode66_Tag {

    @Test
    public void test() {
    }

    /**
     * @param a
     * @return
     */
    public int[] constructArrLeet(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] res = new int[a.length];
        // 计算下三角
        res[0] = 1;
        for (int i = 1; i < a.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        // 计算上三角
        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp = temp * a[i + 1];
            res[i] = res[i] * temp;
        }
        return res;
    }

    /**
     * 分别计算前i项和后i项的积(i=1~n)
     */
    public int[] constructArrMy(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        // left[i]:数组a[0]~a[i]项目和
        // right[i]:数组a[i]~a[end]项目和
        // res[i] = left[i-1]*right[i+1]

        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = a[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] * a[i];
        }

        right[n -1] = a[n-1];
        for (int i = n-2;i>=0;i--) {
            right[i] = right[i+1] * a[i];
        }

        int[] res = new int[n];
        res[0] = right[1];
        res[n-1] = left[n-2];
        for (int i = 1; i < n-1; i++) {
            res[i] = left[i-1]* right[i+1];
        }
        return res;
    }
}
