package NO_0417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private int[][] d = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private int row;
    private int column;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        row = matrix.length;
        column = matrix[0].length;
        // 是否可到达太平洋
        boolean[][] pacific = new boolean[row][column];
        // 是否可到达大西洋
        boolean[][] atlantic = new boolean[row][column];
        // 从岸边出发，深度搜索
        for (int i = 0; i < column; i++) {
            // 上下两岸
            dfs(matrix, pacific, 0, i);
            dfs(matrix, atlantic, row - 1, i);
        }
        for (int j = 0; j < row; j++) {
            // 左右两岸
            dfs(matrix, pacific, j, 0);
            dfs(matrix, atlantic, j, column - 1);
        }
        // 遍历可达数组，得出结果
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] reachable, int x, int y) {
        reachable[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (newX >= 0 && newX < row
                    && newY >= 0 && newY < column
                    && !reachable[newX][newY]
                    && matrix[newX][newY] >= matrix[x][y]) {
                dfs(matrix, reachable, newX, newY);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<int[]> res = new Solution().pacificAtlantic(matrix);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}