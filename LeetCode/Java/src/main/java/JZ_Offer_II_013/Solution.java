package JZ_Offer_II_013;

class NumMatrix {

    private final int[][] sums;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sums = new int[row + 1][col + 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                // 加右边的，加下面的，减对角重复部分
                sums[i][j] = matrix[i][j] + sums[i][j + 1] + sums[i + 1][j] - sums[i + 1][j + 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 减去右边，减去下边，加上重复减去部分
        return sums[row1][col1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row2 + 1][col2 + 1];
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]
                {
                        {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}
                }
        );
        int res = numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
        System.out.println(res);
        res = numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
        System.out.println(res);
        res = numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
        System.out.println(res);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
