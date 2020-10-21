package NO_0073_Set_Matrix_Zeroes;

import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] mFlags = new boolean[m];
        boolean[] nFlags = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    mFlags[i] = true;
                    nFlags[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (mFlags[i]) {
                Arrays.fill(matrix[i], 0);
            } else {
                for (int j = 0; j < n; j++) {
                    if (nFlags[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    public void setZeroes_2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 用于判断第一行和第一列原本是否有 0
        boolean mFlag = false, nFlag = false;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                mFlag = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                nFlag = true;
                break;
            }
        }
        // 将所有的 0 映射到第一行和第一列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 参照第一行和第一列，置换当前位置的元素
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 若第一行和第一列原本有 0，则也需要将第一行和第一列的元素全部置换为 0
        if (mFlag) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (nFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}