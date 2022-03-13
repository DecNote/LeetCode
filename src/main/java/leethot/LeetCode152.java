package leethot;

import org.junit.Test;

import java.util.Stack;

/**
 * @author : Dec
 * @date : 2021/6/15 21:28
 * <p>
 * 1. 分解成两个子问题：求乘积最大的连续子数组 和 求乘积最小的连续子数组
 * 2. 用两个dp数组求解
 */
public class LeetCode152 {


    @Test
    public void test() {
        int[] nums = {-2, 0, -1};
        System.out.println(maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int[] minDp = new int[nums.length];
        int[] maxDp = new int[nums.length];
        minDp[0] = nums[0];
        maxDp[0] = nums[0];
        int res = maxDp[0];

        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(Math.max(nums[i], maxDp[i - 1] * nums[i]), minDp[i - 1] * nums[i]);
            minDp[i] = Math.min(Math.min(nums[i], maxDp[i - 1] * nums[i]), minDp[i - 1] * nums[i]);
            if (maxDp[i] > res) {
                res = maxDp[i];
            }
        }
        return res;
    }


}
