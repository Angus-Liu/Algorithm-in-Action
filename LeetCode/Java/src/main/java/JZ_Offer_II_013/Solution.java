package JZ_Offer_II_013;

class NumMatrix {

    private final int[][] sums;
    private final int row;
    private final int col;

    public NumMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        sums = new int[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                sums[i][j] = matrix[i][j];
                // 加右边的
                boolean right = j + 1 < col;
                sums[i][j] += right ? sums[i][j + 1] : 0;
                // 加下面的
                boolean down = i + 1 < row;
                sums[i][j] += down ? sums[i + 1][j] : 0;
                // 减对角的，重复部分
                sums[i][j] -= (right && down) ? sums[i + 1][j + 1] : 0;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = sums[row1][col1];
        // 减去右边
        boolean right = col2 + 1 < col;
        sum -= right ? sums[row1][col2 + 1] : 0;
        // 减去下边
        boolean down = row2 + 1 < row;
        sum -= down ? sums[row2 + 1][col1] : 0;
        // 加上重复减去部分
        sum += (right && down) ? sums[row2 + 1][col2 + 1] : 0;
        return sum;
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
