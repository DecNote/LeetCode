package record.string;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/9/5 16:12
 *
 * 反转字符串
 */
public class LeetCode541_2 {
    @Test
    public void test() {
//        System.out.println(reverseStr("a", 2));
        char[] chs = "abcdeft".toCharArray();
        reverse(chs, 2, 3);
        System.out.println(new String(chs));
    }

    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i = i + 2 * k) {
            if (chs.length - i < k) {
                reverse(chs, i, chs.length - 1);
            } else {
                reverse(chs, i, i + k - 1);
            }

        }
        return new String(chs);
    }

    public void reverse(char[] chs, int left, int right) {
        if (left >= right) {
            return;
        }
        int n = right - left + 1;
        for (int i = 0; i < n / 2; i++) {
            char temp = chs[left + i];
            chs[left + i] = chs[right - i];
            chs[right - i] = temp;
        }
    }
}
