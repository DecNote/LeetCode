package leethot;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Dec
 * @date : 2021/6/21 17:13
 * <p>
 * 思路：比较字符串组成是否相同（异位字符串）：频次统计
 */
public class LeetCode438 {

    @Test
    public void test() {
        findAnagrams("afdasdffads", "afjsijo");
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new LinkedList<>();
        }


        int[] pFreCount = new int[26];
        int[] sFreCount = new int[26];

        // p字符串频次统计
        for (int i = 0; i < p.length(); i++) {
            pFreCount[p.charAt(i) - 'a']++;
        }

        // s字符串的前p.length个，进行频次统计
        for (int i = 0; i < p.length(); i++) {
            sFreCount[s.charAt(i) - 'a']++;
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (Arrays.equals(pFreCount, sFreCount)) {
                res.add(i);
            }
            if (i + p.length() < s.length()) {
                sFreCount[s.charAt(i) - 'a']--;
                sFreCount[s.charAt(i + p.length()) - 'a']++;
            }
        }


        System.out.println(Arrays.toString(pFreCount));

        return res;
    }

}
