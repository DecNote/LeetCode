package leethot;

import org.junit.Test;

import java.util.*;

/**
 * @author : Dec
 * @date : 2021/6/7 22:55
 * <p>
 * 类似于背包问题，dfs递归
 */
public class LeetCode39 {

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
        System.out.println();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        this.nums = candidates;
        dfs(0, 0);
        return new ArrayList<>(set);
    }

    private HashSet<List<Integer>> set = new HashSet<>();
    private List<Integer> temp = new LinkedList<>();
    private int target;
    private int[] nums;


    /**
     * next表示下一个待决定是否入选的元素
     */
    public void dfs(int sum, int next) {
        if (sum > target || next >= nums.length) {
            return;
        }

        if (sum == target) {
            set.add(new ArrayList<>(temp));
            return;
        }


        temp.add(nums[next]);
        dfs(sum + nums[next], next);
        temp.remove(temp.size() - 1);


        temp.add(nums[next]);
        dfs(sum + nums[next], next + 1);
        temp.remove(temp.size() - 1);

        dfs(sum, next + 1);
    }


}
