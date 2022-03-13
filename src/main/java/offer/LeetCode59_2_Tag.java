package offer;

import org.junit.Test;

import java.util.LinkedList;


/**
 * @author Dec
 * <p>
 * 1. 维护一个单调递减队列
 * 2. Integer对象的比较必须使用equals方法
 */
public class LeetCode59_2_Tag {

    @Test
    public void test() {
    }

    private LinkedList<Integer> queue = new LinkedList<>();

    // 单调递减队列(双端队列)
    private LinkedList<Integer> decreaseQueue = new LinkedList<>();

    class MaxQueue {
        public MaxQueue() {

        }

        public int max_value() {
            if (queue.isEmpty()) {
                return -1;
            }
            return decreaseQueue.getFirst();
        }

        public void push_back(int value) {
            queue.addLast(value);
            while (!decreaseQueue.isEmpty() && decreaseQueue.getLast() < value) {
                decreaseQueue.removeLast();
            }
            decreaseQueue.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            // 注意，对象的比较千万不能使用==，而应该使用equals()，否则答案出错
            if (queue.getFirst() == decreaseQueue.getFirst()) {
                decreaseQueue.removeFirst();
            }
            return queue.removeLast();
        }
    }


}
