package leethot;

import org.junit.Test;

import java.util.Map;

/**
 * @author : Dec
 * @date : 2021/6/8 21:32
 */
public class LeetCode55 {

    @Test
    public void test() {
//        int[] nums = {3, 2, 1, 0, 4};
        int[] nums = {0};
        System.out.println(canJump(nums));
    }


    public boolean canJump(int[] nums) {
        // 可以抵达的最大位置
        int maxPos = 0;

        for (int i = 0; i < nums.length; i++) {
            // 当前位置无法抵达
            if (i > maxPos) {
                return false;
            }
            // 当前位置可以抵达，更新maxPos
            if (nums[i] + i > maxPos) {
                maxPos = nums[i] + i;
            }
            // 判断是否可以到达终点
            if (maxPos >= nums.length - 1) {
                return true;
            }
        }

        // for循环结束时，已经抵达终点，即返回true
        return true;
    }

}
