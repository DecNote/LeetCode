package offer;

import org.junit.Test;
import java.util.LinkedList;


/**
 * @author Dec
 * <p>
 * 1. 用两个栈实现队列功能
 * 2. stack1专门用于入队，stack2专门出队
 * 3. 当要出队时，直接取stack2栈顶元素；如果stack2为空，则把stack1的元素复制到stack2，再出队
 */
public class LeetCode9 {


    @Test
    public void test() {
    }

    class CQueue {
        //

        // 专门用于入队
        private LinkedList<Integer> stack1 = new LinkedList<Integer>();
        // 专门用于出队
        private LinkedList<Integer> stack2 = new LinkedList<Integer>();

        public CQueue() {
        }

        public void appendTail(int value) {
            stack1.addLast(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.removeLast();
            } else if(!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.addLast(stack1.removeLast());
                }
                return stack2.removeLast();
            } else {
                return -1;
            }
        }
    }
}
