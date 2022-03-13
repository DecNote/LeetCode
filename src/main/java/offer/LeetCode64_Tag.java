package offer;

import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 用&&的特性来避免使用if
 */
public class LeetCode64_Tag {

    @Test
    public void test() {
        System.out.println(sumNumsV2(10));
    }


    public int sumNumsV1(int n) {
        int res = 0;
        boolean falg = n > 1 && (res = sumNumsV1(n - 1)) > 0;
        return n + res;
    }

    public int sumNumsV2(int n) {
        boolean falg = n > 1 && (n = n + sumNumsV2(n - 1)) > 0;
        return n;
    }
}
