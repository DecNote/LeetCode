package leethot;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Dec
 * @date : 2021/6/21 21:13
 */
public class LeetCode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }


        List<Integer> res = new LinkedList<>();

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
