package offer;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/9/13 13:35
 */
public class LeetCode44 {

    @Test
    public void test() {
        System.out.println(help());


    }

    public int help() {
        try {
            return 100;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return 0;
        }
    }


    public int findNthDigit(int n) {
        // 当前统计一位长的数字
        int digit = 1;
        // 一位长数字的起点为1
        long start = 1;
        // 一位长数字总共有多少位，即数位个数
        long count = 9;
        while (n > count) {
            n -= count;
            digit++;
            start = start * 10;
            count = digit * start * 9;
        }
        // 找到在100~999中的哪一个数
        long num = start + (n - 1) / digit;
        // 在该数字的第idx位中
        int idx = (n - 1) % digit;
        return String.valueOf(num).charAt(idx) - '0';
    }
}
