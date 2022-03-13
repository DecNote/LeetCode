package record.interview;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/9/14 17:21
 */
public class LeetCode16_05 {
    @Test
    public void test() {
//        System.out.println(trailingZeroes(26));
        System.out.println(trailingZeroes(2147483647));
    }

    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res = res + n / 5;
            n = n / 5;
        }
        return res;
    }


    /**
     * 超时
     */
    public int trailingZeroesV2(int n) {
        int res = 0;
        for (int i = 5; i <= n; i = i + 5) {
            int temp = i;
            System.out.println(i);
            while (temp % 5 == 0) {
                temp = temp / 5;
                res++;
            }
        }
        return res;
    }


}
