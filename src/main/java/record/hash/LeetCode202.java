package record.hash;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author : Dec
 * @date : 2021/9/5 14:13
 * <p>
 * 哈希表找环
 */
public class LeetCode202 {
    @Test
    public void test() {
        System.out.println(isHappy(2));
    }

    public boolean isHappy(int n) {
        // 循环的截止条件是用哈希表去环
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n != 0) {
                sum = sum + (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
