package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


/**
 * @author Dec
 * <p>
 * 1. 双指针
 */
public class LeetCode57_2_Tag {

    @Test
    public void test() {
        int[][] res = findContinuousSequence(15);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }


    }

    /**
     * 双指针（滑动串口）
     */
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> list = new ArrayList<>();

        int left = 1;
        int right = 2;
        int sum;
        while (left < right) {
            // 求和公式
            sum = (right - left + 1) * (left + right) / 2;
            if (sum == target) {
                // 保存结果
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                list.add(temp);
                // 更新left
                left++;
            } else if (sum > target) {
                left++;
            } else {
                right++;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    /**
     * 双指针【推荐版】
     */
    public int[][] findContinuousSequenceGood(int target) {
        int p = 1;
        int q = 1;
        int sum = 1;
        LinkedList<int[]> list = new LinkedList<>();
        while (p <= q && q < target) {
            if (sum == target) {
                int[] temp = new int[q - p + 1];
                for (int i = p; i <= q; i++) {
                    temp[i - p] = i;
                }
                list.add(temp);
                sum = sum - p;
                p++;
                q++;
                sum = sum + q;
            } else if (sum > target) {
                sum = sum - p;
                p++;
            } else {
                q++;
                sum = sum + q;
            }


        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }




    /**
     * 硬查找【不推荐】
     */
    public int[][] findContinuousSequenceMy(int target) {
        int sum;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 1; i <= target / 2 + 1; i++) {
            sum = 0;
            for (int j = i; j <= target / 2 + 1; j++) {
                sum = sum + j;
                if (sum > target) {
                    break;
                }
                if (sum == target) {
                    //添加结果
                    int[] temp = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        temp[k - i] = k;
                    }
                    list.add(temp);
                }

            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
