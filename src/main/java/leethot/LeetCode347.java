package leethot;

import java.util.*;

/**
 * @author : Dec
 * @date : 2021/6/19 23:40
 */
public class LeetCode347 {

    /**
     * 频次统计+堆排序
     */
    public int[] topKFrequentV2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }


        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() == k) {
                if (queue.peek().getValue() < entry.getValue()) {
                    queue.remove();
                    queue.add(entry);
                }
            } else {
                queue.add(entry);
            }
        }



        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[k - 1 - i] = queue.remove().getKey();
        }
        return res;
    }



    /**
     * 频次统计+排序
     */
    public int[] topKFrequentV1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}
