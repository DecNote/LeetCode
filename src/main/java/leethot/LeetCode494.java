package leethot;

/**
 * @author : Dec
 * @date : 2021/6/21 22:00
 */
public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int target) {
        this.nums= nums;
        this.target = target;
        dfs(0, 0);
        return res;
    }

    private int[] nums;
    private int target;
    private int res = 0;

    public void dfs(int p, int sum) {

        if (p == nums.length) {
            if (sum == target) {
                res++;
            }
            return;
        }

        dfs(p + 1, sum + nums[p]);
        dfs(p + 1, sum - nums[p]);
    }
}
