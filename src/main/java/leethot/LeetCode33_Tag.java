package leethot;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/6/7 10:56
 * <p>
 * 1. 二分法对于旋转数组的三种情况(left~right)：
 * 整体有序
 * 左半边有序
 * 右半边有序
 * <p>
 * 比较mid和right，可以得出左半边有序还是右半边有序
 */
public class LeetCode33_Tag {

    @Test
    public void test() {
        int[] nums = {1, 3};
        int res = search(nums, 3);
        System.out.println(res);
    }


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            if (nums[left] < nums[right]) {
                // 全部有序
                return directSearch(nums, left, right, target);
            }
            mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                // 左半边有序
                if (target <= nums[mid]) {
                    int temp = directSearch(nums, left, mid, target);
                    if (temp != -1) {
                        return temp;
                    }
                }
                left = mid + 1;
            } else {
                // 右半边有序
                if (target <= nums[right]) {
                    int temp = directSearch(nums, mid, right, target);
                    if (temp != -1) {
                        return temp;
                    }
                }
                right = mid - 1;
            }
        }

        return -1;
    }


    public int directSearch(int[] nums, int left, int right, int target) {
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
