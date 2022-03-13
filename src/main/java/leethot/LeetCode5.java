package leethot;

/**
 * @author : Dec
 * @date : 2021/7/1 11:23
 * <p>
 * 1. 模直接拟法
 * 2. DP法有问题，且复杂度不低
 * 3. 回文子串的两种情况：...aba... 和 ...baab...
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int n = s.length();

        int begin = 0;
        int end = 0;

        for (int i = 1; i < n - 1; i++) {
            int[] pos = validate(chs, i, i);
            if (end - begin < pos[1] - pos[0]) {
                begin = pos[0];
                end = pos[1];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (chs[i] != chs[i + 1]) {
                continue;
            }
            int[] pos = validate(chs, i, i + 1);
            if (end - begin < pos[1] - pos[0]) {
                begin = pos[0];
                end = pos[1];
            }
        }
        return s.substring(begin, end + 1);
    }


    /**
     * 返回以chs[left]和chs[right]为中心的，回文子串的最大长度
     * 要求传进来的chs[left]=chs[right]
     */
    public int[] validate(char[] chs, int left, int right) {
        int p = left - 1;
        int q = right + 1;
        while (p >= 0 && q < chs.length) {
            if (chs[p] == chs[q]) {
                p--;
                q++;
            } else {
                break;
            }
        }
        p++;
        q--;
        return new int[]{p, q};
    }


    /**
     * 有问题的解法
     *
     * @param s
     * @return
     */
    public String longestPalindromeDp(String s) {
        // do[i][j]：s[i-j]是否是回文子串
        // i=j : dp[i][j] = true
        // j-i=1 : dp[i][j] = s[i]==s[j]
        // other : dp[i][j] = dp[i+1][j-1] && s[i]==s[j]
        // 问题：dp[i][j]的更新用到了还没有计算的dp[i+1][j-1]


        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int begin = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && j - i > end - begin) {
                    begin = i;
                    end = j;
                }

            }
        }
        return s.substring(begin, end + 1);
    }

}
