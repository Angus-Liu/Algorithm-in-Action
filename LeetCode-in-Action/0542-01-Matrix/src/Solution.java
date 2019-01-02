import java.util.Arrays;

class Solution {

    private int row;
    private int col;
    private boolean[][] visited;

    public int[][] updateMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        visited = new boolean[row][col];
        updateMatrix(matrix, 0,0);
        return matrix;
    }


    private int updateMatrix(int[][] matrix, int x, int y) {
        visited[x][y] = true;
        int res = Integer.MAX_VALUE;
        if (matrix[x][y] == 0) {
            res = 0;
        }
        if (x - 1 >= 0 && !visited[x - 1][y]) {
            res = Math.min(res, updateMatrix(matrix, x - 1, y) + 1);
        }
        if (x + 1 < row && !visited[x + 1][y]) {
            res = Math.min(res, updateMatrix(matrix, x + 1, y) + 1);
        }
        if (y - 1 >= 0 && !visited[x][y - 1]) {
            res = Math.min(res, updateMatrix(matrix, x, y - 1) + 1);
        }
        if (y + 1 < col && !visited[x][y + 1]) {
            res = Math.min(res, updateMatrix(matrix, x, y + 1) + 1);
        }
        matrix[x][y] = res;
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        matrix = new Solution().updateMatrix(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}