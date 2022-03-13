package offer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 若递归深度过大，就会导致栈溢出
 * 2. DP思想：当前步骤可以是一步过来的，也可以是两步过来的，因此f(n)=f(n-1)+f(n-2)
 */
public class LeetCode10_2 {


    @Test
    public void test() {
        System.out.println(numWays(9));
    }

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }

        int llast = 1;
        int last = 1;

        int res = llast + last;
        int count = 2;

        while(count <= n) {
            res = (llast + last) % 1000000007;
            llast = last;
            last = res;
            count++;
        }

        return res;
    }


}
