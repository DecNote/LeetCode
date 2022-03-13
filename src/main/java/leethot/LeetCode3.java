package leethot;

import org.junit.Test;

/**
 * @author Dec
 *
 * 1. dp
 */
public class LeetCode3 {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("ababa"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        // dp[i]表示以s[i]结尾的最长不重复子串的长度
        int[] dp = new int[s.length()];
        dp[0] = 1;

        // dp[i]对应的字符串为s[p~i]
        int p = 0;

        // s[i]在dp[i-1]对应的字符串中(s[p~i])有重复，其中s[i]=s[pos]
        int repeatPos = 0;
        // 重复标志位
        boolean isRepeat;


        // 结果
        int max = dp[0];


        for (int i = 1; i < s.length(); i++) {
            isRepeat = false;
            for (int j = p; j <= i - 1; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    repeatPos = j;
                    isRepeat = true;
                    // 更新p，容易遗漏
                    p = repeatPos + 1;
                    break;
                }
            }
            // 有重复：s[i]在dp[i-1]对应的字符串中(s[p~i])有重复，其中s[i]=s[pos]
            if (isRepeat) {
                dp[i] = i - repeatPos;
            } else {
                // 没有重复
                dp[i] = dp[i - 1] + 1;
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;

    }
}
