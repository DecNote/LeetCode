package offer;

import org.junit.Test;


/**
 * @author Dec
 * 1. 双指针法：收尾指针
 * 2. 快慢指针：同向指针
 * 3. 直接新建一个数组，重新赋值
 */
public class LeetCode21 {


    @Test
    public void test() {
    }


    public int[] exchangeV2(int[] nums) {
        int[] res = new int[nums.length];
        int x = 0;
        int y = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                res[x] = nums[i];
                x++;
            } else {
                res[y] = nums[i];
                y--;
            }
        }
        return res;
    }

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
