package leethot;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author : Dec
 * @date : 2021/6/20 15:20
 */
public class LeetCode406 {

    @Test
    public void test() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        reconstructQueue(people);


    }


    public int[][] reconstructQueue(int[][] people) {
        LinkedList<Node> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(new Node(people[i][0], people[i][1]));
        }
        list.sort((o1, o2) -> o2.h - o1.h);
        System.out.println(list);


        return null;
    }

    class Node {
        int h;
        int k;

        public Node(int h, int k) {
            this.h = h;
            this.k = k;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "h=" + h +
                    ", k=" + k +
                    '}';
        }
    }


}
