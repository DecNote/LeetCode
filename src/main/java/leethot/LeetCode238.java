package leethot;

/**
 * @author : Dec
 * @date : 2021/7/19 19:06
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // left[i]表示nums[0-i]之间的乘积
        int[] left = new int[n];
        // right[i]表示nums[i-end]之间的乘积
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        for (int i = n - 2; i > 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        int[] res = new int[n];
        res[0] = right[1];
        res[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }
}
