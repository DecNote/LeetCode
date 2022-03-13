package record.hash;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : Dec
 * @date : 2021/9/5 13:50
 * <p>
 * 使用数组存储字符在所有字符串中出现次数的最小值
 */
public class LeetCode1002 {

    @Test
    public void test() {
        String[] words = {"bella", "label", "roller"};
        System.out.println(commonChars(words));

    }

    public List<String> commonChars(String[] words) {
        List<String> res = new LinkedList<>();

        // 存储字符在所有字符串中出现次数的最小值
        int[] count = new int[26];

        for (int i = 0; i < count.length; i++) {
            count[i] = Integer.MAX_VALUE;
        }


        for (int i = 1; i < words.length; i++) {
            // 频次统计
            int[] temp = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                temp[words[i].charAt(j) - 'a']++;
            }
            // 比较
            for (int j = 0; j < count.length; j++) {
                count[j] = Math.min(count[j], temp[j]);
            }
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                char ch = (char) (((int) 'a') + i);
                res.add(String.valueOf(ch));
                count[i]--;
            }
        }
        return res;
    }
}
