package offer;

import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 双指针
 */
public class LeetCode57_1_Tag {

    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int[] res = twoSum(nums, 9);
        System.out.println(res[0] + " " + res[1]);

    }

    /**
     * 双指针法
     * 因为数组有序，因此不会丢失解
     *
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int p = 0;
        int q = nums.length - 1;
        while (p < q) {
            if (nums[p] + nums[q] == target) {
                return new int[]{nums[p], nums[q]};
            } else if (nums[p] + nums[q] > target) {
                q--;
            } else {
                p++;
            }
        }
        return new int[]{nums[p], nums[q]};
    }
}
