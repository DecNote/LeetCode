package offer;


import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * @author Dec
 * <p>
 * 1. 最小堆
 * 2. 参考为知笔记：堆
 */
public class LeetCode40 {

    @Test
    public void test() {
        int[] array = {2, 5, 2, 6, 1, 7, 9};
        System.out.println(Arrays.toString(getLeastNumbers(array, 3)));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int[] res = new int[k > arr.length ? arr.length : k];
        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = heap.remove();
        }
        return res;
    }

}
