package NO_0048_Rotate_Image;

import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        // 翻转 90° = 先关于 X 轴对称翻转 + 再关于对角线翻转
        for (int i = 0; i < matrix.length / 2; i++) {
            swap(matrix, i, matrix.length - i - 1);
        }
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < x; y++) {
                swap(matrix, x, y, y, x);
            }
        }
    }

    private void swap(int[][] matrix, int r1, int r2) {
        int[] temp = matrix[r1];
        matrix[r1] = matrix[r2];
        matrix[r2] = temp;
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Solution().rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}