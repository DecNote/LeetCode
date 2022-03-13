package leethot;

import java.util.LinkedList;

/**
 * @author : Dec
 * @date : 2021/6/16 10:29
 * <p>
 * bfs方法，需要自己定义节点
 */
public class LeetCode200_2 {
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.flag = new boolean[grid.length][grid[0].length];


        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !flag[i][j]) {
                    bfs(i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private char[][] grid;
    private boolean[][] flag;

    public void bfs(int x, int y) {
        LinkedList<Node> queue = new LinkedList<>();
        flag[x][y] = true;
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.removeLast();

            if (judge(node.x + 1, node.y)) {
                queue.add(new Node(node.x + 1, node.y));
            }
            if (judge(node.x - 1, node.y)) {
                queue.add(new Node(node.x - 1, node.y));
            }
            if (judge(node.x, node.y + 1)) {
                queue.add(new Node(node.x, node.y + 1));
            }
            if (judge(node.x, node.y - 1)) {
                queue.add(new Node(node.x, node.y - 1));
            }

        }

    }

    public boolean judge(int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        if (flag[x][y]) {
            return false;
        }
        if (grid[x][y] == '0') {
            flag[x][y] = true;
            return false;
        }

        flag[x][y] = true;
        return true;
    }


    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
