package offer;

import org.junit.Test;

/**
 * @author Dec
 * <p>
 * 二分法核心：已知分割序列的三点为 left,mid,right，考虑每次操作应该去掉左部分还是右部分
 * <p>
 * 1. 二分法：用中点值和末尾值比较，来决定舍去左边还是右边
 */
public class LeetCode11_Tag {

    @Test
    public void test() {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(minArray(nums));
    }


    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                // 非mid-1
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }


    public int minArraySimple(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            // 最小值在右边，注意不是 >=
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                //
                right--;
            }
        }
        return numbers[left];
    }
}
