package NO_0463_Island_Perimeter;

/**
 * 岛屿的周长
 * https://leetcode-cn.com/problems/island-perimeter/
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null) return 0;
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                if (i == 0 || grid[i - 1][j] == 0) perimeter++;
                if (i == grid.length - 1 || grid[i + 1][j] == 0) perimeter++;
                if (j == 0 || grid[i][j - 1] == 0) perimeter++;
                if (j == grid[i].length - 1 || grid[i][j + 1] == 0) perimeter++;
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(s.islandPerimeter(grid));
    }
}
