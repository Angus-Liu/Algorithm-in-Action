package JZ_Offer_II_105;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    private static final int[][] vecArr = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        return bfs(grid);
    }

    /**
     * 广度有限搜索
     */
    private int bfs(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int maxArea = 0;
        // 岛屿数
        int islandCnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    islandCnt++;
                    int curArea = 0;
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.remove();
                        curArea++;
                        for (int[] v : vecArr) {
                            int nr = cur[0] + v[0];
                            int nc = cur[1] + v[1];
                            if ((0 <= nr && nr < r)
                                    && (0 <= nc && nc < c)
                                    && grid[nr][nc] == 1
                                    && !visited[nr][nc]) {
                                queue.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }

                    }
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        System.out.println("islandCnt = " + islandCnt);
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grids = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 0, 0, 1, 1}
        };
        int maxArea = new Solution().maxAreaOfIsland(grids);
        System.out.println("maxArea = " + maxArea);
    }
}
