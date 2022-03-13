package offer;


import org.junit.Test;

import java.util.LinkedList;


/**
 * @author Dec
 * <p>
 * 自定义排序规则：
 * 若拼接字符串 x + y > y + x ，则 xx “大于” yy ；
 * 反之，若 x + y < y + x ，则 xx “小于” yy ；
 * <p>
 * 核心：不要把问题搞复杂，考虑值进行两个数之间的比较，那么就应该按上诉排序规则
 */
public class LeetCode45 {

    @Test
    public void test() {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(minNumber(nums));


    }

    public String minNumber(int[] nums) {
        LinkedList<String> list = new LinkedList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort(((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));

        StringBuilder res = new StringBuilder();
        for (String s : list) {
            res.append(s);
        }
        return res.toString();
    }
}
