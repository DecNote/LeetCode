package offer;

import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 模拟题
 * 2. 难道：溢出判断；char类型数字转数字(减去'0')
 */
public class LeetCode67_Tag {

    @Test
    public void test() {
    }

    public static int strToInt(String str) {
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }
        int sign = 1;
        int p = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            p++;
            sign = str.charAt(0) == '-' ? -1 : 1;
        }
        int res = 0;
        for (int i = p; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                // 溢出判断
                if (res > Integer.MAX_VALUE / 10) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                if (sign == 1 && res == Integer.MAX_VALUE / 10 && str.charAt(i) > '7') {
                    return Integer.MAX_VALUE;
                }
                if (sign == -1 && res == Integer.MAX_VALUE / 10 && str.charAt(i) > '8') {
                    return Integer.MIN_VALUE;
                }
                // 更新
                res = res * 10 + (str.charAt(i) - '0');
                continue;
            }
            break;
        }
        return sign * res;
    }
}
