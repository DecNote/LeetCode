package leethot;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/6/2 23:08
 * <p>
 * 1. 双指针法
 * 2. 这是一道技巧题，背下
 */
public class LeetCode11 {

    @Test
    public void test() {
        System.out.println(maxAreaV2(new int[]{1, 2}));
    }


    /**
     * 双指针法
     *
     * @param height
     * @return
     */
    public int maxAreaV2(int[] height) {
        int res = 0;
        int p = 0;
        int q = height.length - 1;

        int temp;
        while (p < q) {
            temp = (q - p) * Math.min(height[p], height[q]);
            if (temp > res) {
                res = temp;
            }
            if (height[p] <= height[q]) {
                p++;
            } else {
                q--;
            }
        }
        return res;
    }


    public int maxAreaV1(int[] height) {
        // dp[i]：以柱子i结尾的，且水高为h[i]的最大容量
        // 在0~i-1之间的柱子，找到第一个大于h[i]的柱子，找到了为s
        //dp[i] = h[i] * (i - s);

        int res = 0;
        int[] dp = new int[height.length];
        dp[0] = 0;
        int s;
        for (int i = 1; i < dp.length; i++) {
            s = -1;
            for (int j = 0; j < i; j++) {
                if (height[j] >= height[i]) {
                    s = j;
                    break;
                }
            }
            if (s == -1) {
                dp[i] = 0;
            } else {
                dp[i] = height[i] * (i - s);
            }

            if (dp[i] > res) {
                res = dp[i];
            }
        }

        for (int i = height.length - 2; i >= 0; i--) {
            s = -1;
            for (int j = height.length - 1; j > i; j--) {
                if (height[j] >= height[i]) {
                    s = j;
                    break;
                }

            }

            if (s == -1) {
                dp[i] = Math.max(dp[i], 0);
            } else {
                dp[i] = Math.max(dp[i], height[i] * (s - i));
            }
            if (dp[i] > res) {
                res = dp[i];
            }
        }


        return res;
    }
}
