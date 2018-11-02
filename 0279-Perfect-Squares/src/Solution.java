import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(n, 0));
        // 访问数组，用以防止冗余访问
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int num = pair.getKey();
            int step = pair.getValue();
            // 将节点与每一个平方数的结果压入队列，该节点与每一个平方数之间构成了一幅图
            for (int i = 1; ; i++) {
                int r = num - i * i;
                if (r < 0) {
                    break;
                } else if (r == 0) {
                    //  为 0 时，即找到了该图的最短路径
                    return step + 1;
                } else {
                    // 判断之前是否访问该点
                    if (!visited[r]) {
                        queue.add(new Pair<>(r, step + 1));
                        visited[r] = true;
                    }
                }
            }
        }

        throw new IllegalArgumentException("No Solution");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }
}