package leethot;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Dec
 * @date : 2021/6/10 22:43
 * <p>
 * if判断其实就两种情况
 */
public class LeetCode56 {

    @Test
    public void test() {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] res = merge(intervals);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }


    public int[][] merge(int[][] intervals) {
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        list.sort((o1, o2) -> o1[0] - o2[0]);

        int i = 0;
        while (i < list.size() - 1) {
            int[] curr = list.get(i);
            int[] next = list.get(i + 1);
            // 第二个interval的起点在第一个interval中间
            if (next[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], next[1]);
                list.remove(next);
            } else {
                i++;
            }
        }
        int[][] res = new int[list.size()][];

        for (i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}
