package NO_0200_Number_of_Islands;

class Solution {

    /**
     * 偏移量数组，用来计算指定坐标坐标相邻的上下左右的坐标
     */
    private int[][] d = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    /**
     * 访问标志数组，用来记录指定位置字母是否被访问过（本题只用来标记岛屿）
     */
    private boolean[][] visited;

    private int r;

    private int l;

    public int numIslands(char[][] grid) {
        // flood fill 算法，本质为深度优先遍历
        int res = 0;
        if (grid == null || grid.length == 0) {
            return res;
        }
        r = grid.length;
        l = grid[0].length;
        visited = new boolean[r][l];
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < l; x++) {
                // 遍历到岛屿，且该岛屿未被访问过
                if (grid[y][x] == '1' && !visited[y][x]) {
                    res++;
                    dfs(grid, x, y);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[y][x] = true;
        // 从该岛屿的四周继续搜索
        for (int i = 0; i < d.length; i++) {
            int nextX = x + d[i][0];
            int nextY = y + d[i][1];
            if (0 <= nextX && nextX < l && 0 <= nextY && nextY < r && grid[nextY][nextX] == '1' && !visited[nextY][nextX]) {
                dfs(grid, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().numIslands(
                        new char[][]
                                {
                                        {'1', '1', '0', '1', '0'},
                                        {'1', '1', '0', '1', '0'},
                                        {'1', '1', '0', '0', '0'},
                                        {'0', '0', '0', '0', '0'}
                                }));
    }
}