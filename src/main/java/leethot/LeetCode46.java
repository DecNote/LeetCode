package leethot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Dec
 * @date : 2021/6/8 9:42
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        permutation(0, nums.length - 1);
        return this.res;
    }

    private int[] nums;
    List<List<Integer>> res = new ArrayList<>();

    public void permutation(int begin, int end) {
        if (begin == end) {
            ArrayList<Integer> temp = new ArrayList<>(nums.length);
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
        }
        for (int i = begin; i <= end; i++) {
            swap(begin, i);
            permutation(begin + 1, end);
            swap(begin, i);
        }
    }

    public void swap(int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
