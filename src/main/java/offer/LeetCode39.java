package offer;


import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 众数统计
 * 2. 摩尔投票法
 */
public class LeetCode39 {

    @Test
    public void test() {
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            // 众数次数统计为0，那么假定当前数为众数
            if (count == 0) {
                res = nums[i];
                // count也要更新，容易忘记
                count = 1;
                continue;
            }
            if (nums[i] == res) {
                // 是当前假定的众数
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

}
