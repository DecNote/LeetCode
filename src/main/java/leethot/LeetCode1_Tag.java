package leethot;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Dec
 * <p>
 * 1. 使用哈希表：键存数字，值存位置
 */
public class LeetCode1_Tag {


    @Test
    public void test() {
    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
