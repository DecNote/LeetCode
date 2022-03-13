package leethot;

import org.junit.Test;

import java.util.*;

/**
 * @author : Dec
 * @date : 2021/6/5 13:20
 */
public class LeetCode17 {


    @Test
    public void test() {
        System.out.println();
        System.out.println(letterCombinations("38"));
    }
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new LinkedList<String>();
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            addRes(digits.charAt(i));
        }
        return res;


    }

    private HashMap<Character, String> map = new HashMap<>();
    private List<String> res = new LinkedList<>();

    public void addRes(char c) {

        if (res.size() == 0) {
            for (int i = 0; i < map.get(c).length(); i++) {
                res.add(map.get(c).substring(i, i + 1));
            }
            return;
        }

        int n = res.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < map.get(c).length(); j++) {
                res.add(res.get(i) + map.get(c).charAt(j));
            }
        }
        for (int i = 0; i < n; i++) {
            res.remove(0);
        }
    }
}
