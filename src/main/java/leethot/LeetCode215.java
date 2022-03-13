package leethot;

import java.util.PriorityQueue;

/**
 * @author : Dec
 * @date : 2021/6/16 23:18
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)->o2-o1);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.remove();
        }
        return queue.remove();
    }
}
