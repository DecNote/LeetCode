package leethot;

import java.util.Arrays;

/**
 * @author : Dec
 * @date : 2021/6/21 23:33
 */
public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {

        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(copy);

        int p = 0;
        int q = nums.length - 1;
        while (p < nums.length) {
            if (nums[p] != copy[p]) {
                break;
            }
            p++;
        }
        if (p == nums.length) {
            return 0;
        }
        while (q >= 0) {
            if (nums[q] != copy[q]) {
                break;
            }
            q--;
        }
        return q - p + 1;
    }

}
