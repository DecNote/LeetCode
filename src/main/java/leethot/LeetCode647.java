package leethot;

/**
 * @author : Dec
 * @date : 2021/7/22 13:38
 */
public class LeetCode647 {
    public int countSubstrings(String s) {
        chs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            expand(i, i);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            expand(i, i + 1);
        }
        return res;
    }

    private char[] chs;
    private int res;

    public void expand(int left, int right) {
        int p = left;
        int q = right;
        while (p >= 0 && q < chs.length) {
            if (chs[p] == chs[q]) {
                res++;
                p--;
                q++;
            } else {
                break;
            }
        }
    }
}
