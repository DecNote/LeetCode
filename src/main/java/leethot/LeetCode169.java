package leethot;

/**
 * @author : Dec
 * @date : 2021/7/13 17:19
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {

        int num = nums[0];
        int vote = 0;

        for (int i = 1; i < nums.length; i++) {
            if (vote == 0) {
                num = nums[i];
                vote = 1;
            } else {
                if (nums[i] == num) {
                    vote++;
                } else {
                    vote--;
                }
            }
        }
        return num;
    }
}
