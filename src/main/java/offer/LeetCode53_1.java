package offer;


import org.junit.Test;


/**
 * @author Dec
 */
public class LeetCode53_1 {

    @Test
    public void test() {

//        int[] nums = {5,7,7,8,8,10};
        int[] nums = {};
        int target = 8;
        System.out.println(search(nums, target));

    }

    public int search(int[] nums, int target) {
        int res = 0;

        int pos = binarySearch(nums, 0, nums.length - 1, target);
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] == target) {
                res++;
            } else {
                break;
            }

        }
        return res;
    }

    /**
     * 二分查找：查找第一个 >=
     */
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
