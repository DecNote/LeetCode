package leethot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Dec
 * @date : 2021/6/11 11:14
 *
 * 1. 子集问题，n个元素有 2^n 个子集
 * 2. 二进制法求解
 */
public class LeetCode78_2_Tag {

    @Test
    public void test() {
        int[] nums = {1, 2};
        System.out.println(subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        // 结果的总个数
        int total = 1 << n;

        List<List<Integer>> res = new ArrayList<>(total);

        for (int mask = 0; mask < total; mask++) {
            LinkedList<Integer> list = new LinkedList<>();

            // 依次取出mask的每一位二进制，为1表示加入子集，为0表示不加入
            int temp = mask;
            for (int i = 0; i < n; i++) {
                if ((temp & 1) == 1) {
                    list.add(nums[i]);
                }
                temp = temp >>> 1;
            }
            res.add(list);

        }
        return res;
    }
}
