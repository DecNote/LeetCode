package offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * @author Dec
 * <p>
 * 1. 模拟题，理解顺子的要求即可
 */
public class LeetCode61_Tag {

    @Test
    public void test() {
    }


    public boolean isStraightMy(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }
            if (set.contains(nums[i])) {
                return false;
            } else {
                set.add(nums[i]);
            }
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        int count = 0;
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                count++;
            }
        }
        return zeroCount >= count;
    }

    public boolean isStraight(int[] nums) {
        // 顺子要求：最大-最小<=4 ; 不重复(除去0)

        int min = 100;
        int max = -1;
        HashSet<Integer> set = new HashSet<>(5);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max - min <= 4;
    }
}
