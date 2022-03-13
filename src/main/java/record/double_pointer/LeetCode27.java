package record.double_pointer;

/**
 * @author : Dec
 * @date : 2021/9/5 17:02
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                res++;
                nums[idx++] = nums[i];
            }
        }
        return res;

    }
}
