package offer;

import java.util.HashSet;

/**
 * @author Dec
 * <p>
 * 1. 哈希表去重
 */
public class LeetCode3 {
    public int findRepeatNumberV1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return nums[i];
            }
        }
        return 0;
    }
}
