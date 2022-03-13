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
public class LeetCode14_2 {


    @Test
    public void test() {
        System.out.println(cuttingRope(120));
    }

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n % 3;
        int b = n / 3;


        if (a == 0) {
            return calculate(b);
        } else if (a == 2) {
            return (calculate(b) * 2) % 1000000007;
        } else {
            return (((calculate(b - 1) * 2) % 1000000007) * 2) % 1000000007;
        }
    }

    public int calculate(int b) {
        long res = 1;
        for (int i = 0; i < b; i++) {
            res = (res * 3) % 1000000007;
        }
        return (int) res;
    }
}
