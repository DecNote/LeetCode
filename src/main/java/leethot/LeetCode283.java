package leethot;

/**
 * @author : Dec
 * @date : 2021/6/17 20:36
 * <p>
 * 把某类数字往后移动的问题
 */
public class LeetCode283 {


    /**
     *
     */
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前数字不等于0，那么idx和i是一样的
            if (nums[i] != 0) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    /**
     * 遇到0往后移
     *
     * @param nums
     */
    public void moveZeroesV2(int[] nums) {

        // count表示 非0 元素的个数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                count++;
            }
        }

        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 遇到0往后移
     *
     * @param nums
     */
    public void moveZeroesV1(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[j - 1];
                        nums[j - 1] = nums[j];
                        nums[j] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
