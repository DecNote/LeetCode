package leethot;

import org.junit.Test;

import java.util.*;

/**
 * @author : Dec
 * @date : 2021/6/8 11:00
 * <p>
 * 1. 比较两个异位但组成相同的字符串，两种思路：频次统计 和 排序后比较
 * 2. 使用Map，问题在于使用什么作为key？
 */
public class LeetCode49_Tag {

    @Test
    public void test() {


        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // String转字符数组并排序
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            // 排序完转String作为Map的key【char[]不能作为key，因此需要转换思路，char[]转为其他类型作为key】
            String key = new String(chars);

            // 存入Map
            if (map.get(key) == null) {
                List<String> temp = new LinkedList<>();
                temp.add(strs[i]);
                map.put(key, temp);
            } else {
                map.get(key).add(strs[i]);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
