package record.dp;

import org.junit.Test;

/**
 * @author : Dec
 * @date : 2021/9/8 14:03
 */
public class LeetCode474 {

    @Test
    public void test() {
        int m = 5;
        int n = 3;
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, m, n));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]:最多i个0和j个1的子集元素最大数
        int[][] dp = new int[m + 1][n + 1];
        // dp[i][j] = dp[i-0的个数][j-1的个数] + 1


        for (int idx = 0; idx < strs.length; idx++) {
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    int oneNum = countOne(strs[idx]);
                    int zeroNum = strs[idx].length() - oneNum;
                    if (i - zeroNum >= 0 && j - oneNum >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                    }
                }
            }
        }
        return dp[m][n];

    }

    public int countOne(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }


}
