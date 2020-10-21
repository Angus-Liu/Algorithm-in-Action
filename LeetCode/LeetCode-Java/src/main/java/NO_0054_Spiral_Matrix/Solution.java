package NO_0054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder_1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (left > right || top > bottom) {
                break;
            }

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right || top > bottom) {
                break;
            }

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (left > right || top > bottom) {
                break;
            }

            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right || top > bottom) {
                break;
            }
        }

        return res;
    }

    /**
     * 参考：https://leetcode.com/problems/spiral-matrix/discuss/20571/1-liner-in-Python-%2B-Ruby
     */
    private List<Integer> res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        Arrays.stream(matrix[0]).forEach(res::add);
        int r = matrix.length;
        int c = matrix[0].length;
        if (r > 1) {
            int[][] nextMatrix = new int[c][r - 1];
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < r - 1; j++) {
                    nextMatrix[i][j] = matrix[j + 1][c - 1 - i];
                }
            }
            spiralOrder(nextMatrix);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        // [1,2,3,6,9,8,7,4,5]
        List<Integer> res = new Solution().spiralOrder(matrix);
        System.out.println(res);

        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        // matrix = new int[][]{{1}};
        // [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
        res = new Solution().spiralOrder(matrix);
        System.out.println(res);
    }
}