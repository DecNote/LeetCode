package leethot;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/6/7 22:46
 * <p>
 * 二分查找
 */
public class LeetCode34 {


    @Test
    public void test() {
        int[] nums = {1, 2};
        int[] res = searchRange(nums, 2);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] searchRange(int[] nums, int target) {

        int begin = binarySearch(nums, 0, nums.length - 1, target);
        int end = -1;
        for (int i = begin; i < nums.length; i++) {
            if (nums[i] == target) {
                end = i;
            } else {
                break;
            }
        }
        if (end == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{begin, end};
        }

    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
