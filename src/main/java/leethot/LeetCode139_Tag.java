package leethot;

import java.util.HashSet;
import java.util.List;

/**
 * @author : Dec
 * @date : 2021/6/12 15:50
 *
 * 1. dp思想
 * 2. dp[i]表示s[0~i]是否可以正确拆分，那么更新公式...
 */
public class LeetCode139_Tag {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        // dp[i]表示s[0~i]是否可以正确拆分
        boolean[] dp = new boolean[s.length()];
        dp[0] = set.contains(s.substring(0, 1));

        for (int i = 1; i < s.length(); i++) {
            dp[i] = set.contains(s.substring(0, i + 1));
            if (dp[i]) {
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (dp[j - 1] && set.contains(s.substring(j, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }


}
