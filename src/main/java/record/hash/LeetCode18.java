package record.hash;

import org.junit.Test;

import java.util.*;

/**
 * @author : Dec
 * @date : 2021/9/5 15:04
 *
 * 三数之和：一个指针，从1 ~ n-1，在指针两侧找分别找一个数，让和为target
 * 四数之和：两个指针...
 */
public class LeetCode18 {
    @Test
    public void test() {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        System.out.println(fourSum(nums, 0));
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(fourSum(nums, 8));
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();

        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > 1; j--) {
                if (i >= j) {
                    continue;
                }
                int p = i - 1;
                int q = j + 1;
                while (p >= 0 && q < nums.length) {
                    int temp = nums[p] + nums[q] + nums[i] + nums[j];
                    if (temp == target) {
                        ArrayList<Integer> list = new ArrayList<>(4);
                        Collections.addAll(list, nums[p], nums[i], nums[j], nums[q]);
                        res.add(list);
                        p--;
                        q++;
                    } else if (temp > target) {
                        p--;
                    } else {
                        q++;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

}
