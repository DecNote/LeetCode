package leethot;

import org.junit.Test;

import java.util.*;

/**
 * @author : Dec
 * @date : 2021/6/4 21:47
 * <p>
 * 1. 先排序，再对剩下的进行二分查找
 * 2. (左边，当前数，右边)
 */
public class LeetCode15_Tag {

    @Test
    public void test() {
    }


    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            int p = 0;
            int q = n - 1;
            while (p < q && p != i && q != i) {
                if (nums[i] + nums[p] + nums[q] == 0) {
                    ArrayList<Integer> list = new ArrayList<>(3);
                    Collections.addAll(list, nums[p], nums[i], nums[q]);
                    set.add(list);
                    p++;
                    q--;
                } else if (nums[i] + nums[p] + nums[q] > 0) {
                    q--;
                } else {
                    p++;
                }
            }
        }
        return new LinkedList<>(set);
    }
}
