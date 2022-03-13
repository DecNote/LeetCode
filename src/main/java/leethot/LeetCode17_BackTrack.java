package leethot;

import org.junit.Test;

import java.util.*;

/**
 * @author : Dec
 * @date : 2021/6/5 13:20
 */
public class LeetCode17_BackTrack {


    @Test
    public void test() {
        System.out.println();
        System.out.println(letterCombinations("383"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }

        this.digits = digits;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(0, new StringBuffer());
        return res;
    }


    private Map<Character, String> map = new HashMap<>();
    private List<String> res = new ArrayList<>();
    private String digits;


    /**
     * 当前待添加号码为digits[idx]
     */
    public void backtrack(int idx, StringBuffer curStr) {
        if (idx == digits.length()) {
            res.add(curStr.toString());
            return;
        }

        for (int i = 0; i < map.get(digits.charAt(idx)).length(); i++) {
            curStr.append(map.get(digits.charAt(idx)).charAt(i));
            backtrack(idx + 1, curStr);
            curStr.delete(idx, idx + 1);
        }
    }
}
