package leethot;

/**
 * @author : Dec
 * @date : 2021/6/21 21:30
 */
public class LeetCode461 {

    public int hammingDistance(int x, int y) {
        int res = 0;
        while (x != 0 || y != 0) {
            res += (x & 1) ^ (y & 1);
            x = x >>> 1;
            y = y >>> 1;
        }
        return res;
    }
}
