package offer;


import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author Dec
 * <p>
 * 1. 模拟题，使用哈希表
 * 2. 用set保存已经重复出现过的字符
 */
public class LeetCode50_Tag {

    @Test
    public void test() {
        System.out.println(firstUniqChar("cc"));

    }


    public char firstUniqCharMy(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        if (s.length() == 1) {
            return s.charAt(0);
        }
        int p = 0;
        int i;
        HashSet<Character> repeatSet = new HashSet<>();
        while (p < s.length()) {
            if (repeatSet.contains(s.charAt(p))) {
                p++;
                continue;
            }
            for (i = p + 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(p)) {
                    repeatSet.add(s.charAt(i));
                    break;
                }
            }

            if (i == s.length()) {
                return s.charAt(p);
            }
            p++;
        }
        return ' ';
    }
}
