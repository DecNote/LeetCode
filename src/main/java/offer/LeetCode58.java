package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


/**
 * @author Dec
 */
public class LeetCode58 {

    @Test
    public void test() {
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] array = s.split("[ ]+");
        StringBuilder res = new StringBuilder(array[0]);
        for (int i = 1; i < array.length; i++) {
            res.insert(0, " ").insert(0, array[i]);
        }
        return res.toString();
    }

}
