package offer;


import org.junit.Test;

import java.util.ArrayList;


/**
 * @author Dec
 * <p>
 * 1. DP思路
 * 2. 递归思路
 */
public class LeetCode46 {

    @Test
    public void test() {
//        System.out.println(translateNumV1(648006092));
//        System.out.println(translateNumV2(648006092));
        System.out.println(translateNumV2(15));


    }

    /**
     * DP
     *
     * @param num
     * @return
     */
    public int translateNumV1(int num) {
        if (num <= 9) {
            return 1;
        }
        if (num <= 25) {
            return 2;
        }
        if (num <= 99) {
            return 1;
        }

        int temp = num;
        ArrayList<Integer> list = new ArrayList<>();
        while (temp != 0) {
            list.add(0, temp % 10);
            temp = temp / 10;
        }
        int[] dp = new int[list.size()];
        dp[0] = 1;
        int val = list.get(0) * 10 + list.get(1);
        if (val < 9 || val > 25) {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }

        int i = 2;
        while (i < list.size()) {
            val = list.get(i - 1) * 10 + list.get(i);
            if (val <= 9 || val > 25) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            i++;
        }
        return dp[list.size() - 1];

    }


    private int res = 0;
    private int[] nums;

    /**
     * 递归
     *
     * @param num
     * @return
     */
    public int translateNumV2(int num) {
        this.nums = new int[String.valueOf(num).length()];
        int temp = num;
        int idx = nums.length - 1;
        while (temp != 0) {
            nums[idx--] = temp % 10;
            temp = temp / 10;
        }
        dfs(0);
        return this.res;
    }


    public void dfs(int count) {
        if (count == nums.length) {
            this.res++;
            return;
        }

        dfs(count + 1);

        if (count + 1 < nums.length) {
            int val = nums[count] * 10 + nums[count + 1];
            if (val >= 10 && val <= 25) {
                dfs(count + 2);
            }
        }


    }
}
