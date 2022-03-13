package offer;

import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 考察位运算
 * 2. a+b = 非进位和 + 进位 = a^b + (a&b)<<1
 */
public class LeetCode65_Tag {

    @Test
    public void test() {
        System.out.println(addLeet(888, 1010));
    }


    public int addLeet(int a, int b) {
        // 保存进位
        int c;
        while (b != 0) {
            // 进位（注意要加括号）
            c = (a & b) << 1;

            // 非进位和
            a = a ^ b;

            // 进位再下一个循环在加
            b = c;
        }
        return a;
    }

    public int add(int a, int b) {
        // 当进位为 0 时跳出
        while (b != 0) {
            System.out.println("相加前");
            System.out.println("a" + " : " + Integer.toBinaryString(a));
            System.out.println("b" + " : " + Integer.toBinaryString(b));
            // c = 进位
            int c = (a & b) << 1;
            System.out.println(Integer.toBinaryString(a & b));
            System.out.println("a和b的进位c" + " : " + Integer.toBinaryString(c));
            System.out.println("相加后");
            // a = 非进位和
            a = a ^ b;


            // 令 b=进位，再进入循环
            b = c;

            System.out.println("a" + " : " + Integer.toBinaryString(a));
            System.out.println("b" + " : " + Integer.toBinaryString(b));

            System.out.println("-----------------------------------");
        }
        return a;
    }
}
