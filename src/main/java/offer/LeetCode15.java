package offer;

import org.junit.Test;


/**
 * @author Dec
 * 1. 移位运算，参考笔记
 */
public class LeetCode15 {


    @Test
    public void test() {
        System.out.println(hammingWeight(11));
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            // 无符号右移
            n = n >>> 1;
        }
        return res;
    }


}
