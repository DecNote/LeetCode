package offer;


import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


/**
 * @author Dec
 * <p>
 * 【不会做】
 */
public class LeetCode49_Tag {

    @Test
    public void test() {
        System.out.println(nthUglyNumber(100));

    }

    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.remove();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

}
