package offer;


import org.junit.Test;

import java.util.HashSet;

/**
 * @author Dec
 * <p>
 * 1. 全排列
 * 2. 参考为知笔记：全排列
 */
public class LeetCode38_Tag {

    @Test
    public void test() {
        String s = "aac";
        permutation(s);

        for (String re : res) {
            System.out.println(re);
        }

    }

    private String[] res;
    private HashSet<String> set;


    public String[] permutation(String s) {

        this.set = new HashSet<String>();
        char[] array = new char[s.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = s.charAt(i);
        }

        dfs(array, 0, array.length - 1);


        this.res = new String[set.size()];
        int idx = 0;
        for (String str : set) {
            res[idx++] = str;
        }

        return this.res;
    }

    public void dfs(char[] array, int p, int q) {
        if (p == q) {
            this.set.add(new String(array));
        }

        for (int i = p; i <= q; i++) {
            swap(array, p, i);
            dfs(array, p + 1, q);
            swap(array, p, i);
        }
    }

    public void swap(char[] array, int p, int q) {
        char temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }
}
