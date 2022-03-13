package offer;

import org.junit.Test;

/**
 * @author Dec
 */
public class LeetCode20 {


    @Test
    public void test() {
        System.out.println(isNumberV2("95944e0.94"));
//        System.out.println("0.97".matches("[+-]?\\d+[.]\\d+"));
    }

    /**
     * 投机取巧的方法
     *
     * @param s
     * @return
     */
    public boolean isNumberV1(String s) {
        s = s.trim();

        if (s.length() == 0 || s.charAt(s.length() - 1) > '9') {
            return false;
        }

        boolean flag1 = true;
        boolean flag2 = true;

        try {
            Integer.valueOf(s);
        } catch (Exception e) {
            flag1 = false;
        }
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            flag2 = false;
        }
        return flag1 || flag2;
    }

    /**
     * 解答出错
     *
     * @param s
     * @return
     */
    public boolean isNumberV2(String s) {
        // 整数
        if (s.matches("[+-]?\\d+")) {
            return true;
        }
        // 小数
        if (s.matches("[+-]?\\d+[.]\\d+") || s.matches("[+-]?[.]\\d+") || s.matches("[+-]?\\d+[.]")) {
            return true;
        }
        // 科学计数
        s = s.toLowerCase();
        if (s.contains("e")) {
            String[] split = s.split("e");
            // 前半部分判断
            boolean flag1 = split[0].matches("[+-]?\\d+") || split[0].matches("[+-]?\\d+[.]\\d+");

            // 后半部分判断
            boolean flag2 = split[1].matches("[+-]?\\d+") || split[1].matches("[+-]?\\d+[.]\\d+");
            if (flag2 && flag1) {
                return true;
            }

        }
        return false;
    }
}
