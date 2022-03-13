package offer;

import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 推论1：将绳子 以相等的长度等分为多段 ，得到的乘积最大
 * 2. 推论2：尽可能将绳子以长度 33 等分为多段时，乘积最大
 * 3. 3 x 3 x 1   <   3 x 2 x 2
 * 4. 初始值注意按照题意
 */
public class LeetCode14_1_Tag {


    @Test
    public void test() {

    }


    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        if (n % 3 == 1) {
            return (int) Math.pow(3, n / 3 - 1) * 2 * 2;
        } else if (n % 3 == 2) {
            return (int) Math.pow(3, n / 3) * 2;
        } else {
            return (int) Math.pow(3, n / 3);
        }
    }


}
