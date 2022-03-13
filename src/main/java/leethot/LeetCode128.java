package leethot;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author : Dec
 * @date : 2021/6/12 17:54
 * <p>
 * 1. 题意：0,0,1,2 长度算 3
 * 2. 使用哈希表
 */
public class LeetCode128 {

    @Test
    public void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (Integer s : set) {

            // 确保下面的操作是以s为起点
            if (!set.contains(s - 1)) {
                // 计算以s为起点的最长数字
                int len = 1;
                int num = s;
                while (set.contains(num + 1)) {
                    num++;
                    len++;
                }

                if (len > maxLen) {
                    maxLen = len;
                }
            }


        }

        return maxLen;
    }


}
