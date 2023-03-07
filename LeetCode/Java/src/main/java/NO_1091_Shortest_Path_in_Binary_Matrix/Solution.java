package NO_1091_Shortest_Path_in_Binary_Matrix;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    /**
     * 方向数组
     * 1,1  1,2  1,3
     * 2,1  2,2  2,3
     * 3,1  3,2  3,3
     */
    private final int[][] vector = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    /**
     * DFS 会超时
     */
    public int shortestPathBinaryMatrix1(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        boolean[][] visited = new boolean[n][n];
        int[][] paths = new int[n][n];
        int shortestPath = dfs(grid, visited, paths, n, 0, 0, 1);
        return shortestPath == Integer.MAX_VALUE ? -1 : shortestPath;
    }

    private int dfs(int[][] grid, boolean[][] visited, int[][] paths, int n, int i, int j, int path) {
        if (i == n - 1 && j == n - 1) return path;
        if (paths[i][j] != 0 && path >= paths[i][j]) return paths[i][j];
        int shortestPath = Integer.MAX_VALUE;
        visited[i][j] = true;
        for (int[] v : vector) {
            int r = i + v[0], c = j + v[1];
            if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0 && !visited[r][c]) {
                shortestPath = Math.min(shortestPath, dfs(grid, visited, paths, n, r, c, path + 1));
            }
        }
        paths[i][j] = shortestPath;
        visited[i][j] = false;
        return shortestPath;
    }


    /**
     * BFS
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0] == 0 ? 1 : -1;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int path = 1;
        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();
                for (int[] v : vector) {
                    int x = p[0] + v[0], y = p[1] + v[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                        if (x == n - 1 && y == n - 1) return path;
                        queue.add(new int[]{x, y});
                        grid[x][y] = 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.shortestPathBinaryMatrix(
                new int[][]{
                        {0, 1},
                        {1, 0}
                });
        System.out.println("res = " + res);

        res = solution.shortestPathBinaryMatrix(
                new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 0, 0}
                });
        System.out.println("res = " + res);

        res = solution.shortestPathBinaryMatrix(
                new int[][]{
                        {0, 1, 0, 0, 1, 1, 0},
                        {1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 1, 1, 1, 1},
                        {0, 1, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 1, 0, 0, 0},
                        {1, 0, 1, 0, 0, 1, 0}
                }
        );
        System.out.println("res = " + res);
        // [0,1,1,0,0,0],
        // [0,1,0,1,1,0],
        // [0,1,1,0,1,0]
        // [0,0,0,1,1,0],
        // [1,1,1,1,1,0],
        // [1,1,1,1,1,0]
    }
}
