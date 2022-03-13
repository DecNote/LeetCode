package offer;


import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 【二分法边界问题】
 */
public class LeetCode53_2 {

    @Test
    public void test() {
        int[] array = {0, 1};
        System.out.println(missingNumberLeet(array));

    }

    public int missingNumberLeet(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid - 1] == mid - 1 && nums[mid] != mid) {
                return mid;
            } else if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid + 1;
            }
        }
        return right;
    }

}
