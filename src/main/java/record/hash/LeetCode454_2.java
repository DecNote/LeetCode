package record.hash;

import java.util.HashMap;

/**
 * @author : Dec
 * @date : 2021/9/5 14:41
 * 1. 求A和B中元素两两搭配和的所有可能，保存在map<和，和的次数>
 * 2. 求C和D中元素两两搭配和的所有可能，保存在map<和，和的次数>
 * 3. 找两个map的key相加为0的部分
 */
public class LeetCode454_2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;

        // 对于数组A和B来说，key为a+b的和，value为和出现的次数
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int key = nums1[i] + nums2[j];
                if (map1.containsKey(key)) {
                    map1.put(key, map1.get(key) + 1);
                } else {
                    map1.put(key, 1);
                }
            }
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int key = nums3[i] + nums4[j];
                if (map2.containsKey(key)) {
                    map2.put(key, map2.get(-key) + 1);
                } else {
                    map2.put(key, 1);
                }
            }
        }

        for (int key : map1.keySet()) {
            if (map2.containsKey(-key)) {
                res = res + map1.get(key) * map2.get(key);
            }
        }

        return res;
    }
}
