package record.array;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/9/7 10:24
 * <p>
 * 滑动窗口
 */
public class LeetCode209_Tag {
    @Test
    public void test() {
        int target = 213;
        int[] nums = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
//        int target = 4;
//        int[] nums = {1, 4, 4};

        System.out.println(minSubArrayLen(target, nums));


    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        int sum = 0;
        for (right = 0; right < nums.length; right++) {
            if (left == right && right == 8) {
                System.out.println();
            }
            sum = sum + nums[right];
            while (sum >= target) {
                res = Math.min(right - left + 1, res);
                sum = sum - nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    public int minSubArrayLenWindow(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = nums[0];
        int res = Integer.MAX_VALUE;
        while (left <= right && right < nums.length) {
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum = sum - nums[left];
                left++;
            } else {
                right++;
                if (right < nums.length) {
                    sum = sum + nums[right];
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
