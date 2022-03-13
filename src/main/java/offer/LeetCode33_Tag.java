package offer;

import org.junit.Test;


/**
 * @author Dec
 * <p>
 * 1. 由后序遍历判断是否是二叉搜索树
 * 2. 【【【while和for出现不一致】】】
 */
public class LeetCode33_Tag {

    @Test
    public void test() {
        int[] postorder = {4, 6, 7, 5};
        System.out.println(verifyPostorder(postorder));
    }

    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length - 1);
    }

    public boolean check(int[] postorder, int p, int q) {
        if (p >= q) {
            return true;
        }

        int rootVal = postorder[q];

        // 右子树起点位置【【【 <= 和 >= 对应没有右子树情况 】】】
        int pos = p;
//        for (int i = p; i <= q; i++) {
//            if (postorder[i] >= rootVal) {
//                pos = i;
//                break;
//            }
//        }

        // while可以避免上述问题
        while (postorder[pos] < rootVal) {
            pos++;
        }

        System.out.println();


        for (int i = pos; i < q; i++) {
            if (postorder[i] < rootVal) {
                return false;
            }
        }
        // 左子树和右子树都得判断一下
        return check(postorder, p, pos - 1) && check(postorder, pos, q - 1);
    }
}
