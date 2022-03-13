package offer;

import org.junit.Test;


/**
 * @author Dec
 * 1. 整数二进制右移一位表示移位运算，参考笔记
 * 2. 指数项转换成2的n次幂展开
 * 3. 移位运算法，首选使用无符号右移 >>>
 * 4. 【如果题目可以用到2的展开式，那么应该联想到 &1，可以求出二进制，即2的展开式】
 * 5. 多写几遍，逻辑比较复杂
 */
public class LeetCode16_Tag {


    @Test
    public void test() {
        System.out.println(myPow(2, -2147483648));
    }

    public double myPow(double x, int n) {
        double res = 1;
        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }
        while (n != 0) {
            if ((n & 1) != 0) {
                res = res * x;
            }
            x = x * x;
            n = n >>> 1;
        }
        return res;
    }
}
