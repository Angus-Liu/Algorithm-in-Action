package NO_1254_Number_of_Closed_Islands;

class Solution {

    /**
     * 方向数组
     */
    private final int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    private boolean dfs(int[][] grid, boolean[][] visited, int row, int col, int i, int j) {
        boolean isClosedIsland = !(i == 0 || i == row - 1 || j == 0 || j == col - 1);
        if (!visited[i][j]) {
            visited[i][j] = true;
            for (int[] v : vector) {
                int r = i + v[0], c = j + v[1];
                if (r >= 0 && r < row && c >= 0 && c < col && grid[r][c] == 0) {
                    isClosedIsland = dfs(grid, visited, row, col, r, c) && isClosedIsland;
                }
            }
        }
        return isClosedIsland;
    }

    /**
     * DFS 求出所有岛屿，这其中不与边界接壤的岛屿即是封闭岛屿
     */
    public int closedIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0
                        && !visited[i][j]
                        && dfs(grid, visited, row, col, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        int res = solution.closedIsland(grid);
        System.out.println("res = " + res);
    }
}
