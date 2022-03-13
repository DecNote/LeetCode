package leethot;

import org.junit.Test;

import java.util.*;

/**
 * @author : Dec
 * @date : 2021/6/11 10:27
 * <p>
 * 1. dfs方法，当成背包问题
 * 2. 子集问题，n个元素有 2^n 个子集
 * 3. 也可以使用非递归来解决，联系二进制
 *
 */
public class LeetCode78 {

    @Test
    public void test() {
        int[] nums = {1};
        System.out.println(subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return res;
    }

    private int[] nums;
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> temp = new LinkedList<>();


    public void dfs(int k) {
        if (k == nums.length) {
            res.add(new LinkedList<>(temp));
            return;
        }

        dfs(k + 1);

        temp.add(nums[k]);
        dfs(k + 1);
        temp.removeLast();
    }
}
