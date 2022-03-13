package record.array;

/**
 * @author : Dec
 * @date : 2021/9/6 23:25
 * <p>
 * 思维能力
 */
public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int[] res = new int[nums.length];

        int p = 0;
        int q = nums.length - 1;

        int idx = nums.length - 1;
        while (p <= q) {
            if (nums[p] > nums[q]) {
                res[idx--] = nums[p++];
            } else {
                res[idx--] = nums[q--];
            }
        }
        return res;
    }
}
