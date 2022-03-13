package leethot;

/**
 * @author : Dec
 * @date : 2021/6/12 21:03
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
