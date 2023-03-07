package NO_0547_Number_of_Provinces;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    /**
     * BFS
     */
    public int findCircleNum1(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int j = queue.remove();
                    visited[j] = true;
                    for (int k = 0; k < n; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.add(k);
                        }
                    }
                }
                res++;
            }
        }
        return res;
    }

    /**
     * DFS
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, n, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int n, int i) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, n, j);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int res = solution.findCircleNum(isConnected);
        System.out.println("res = " + res);

        int[][] isConnected2 = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        res = solution.findCircleNum(isConnected2);
        System.out.println("res = " + res);
    }
}
