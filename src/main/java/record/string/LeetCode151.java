package record.string;

/**
 * @author : Dec
 * @date : 2021/9/5 16:38
 */
public class LeetCode151 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] array = s.split("[ ]+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            res.append(array[array.length - 1 - i]);
            res.append(" ");
        }
        res.append(array[0]);
        return res.toString();
    }
}
