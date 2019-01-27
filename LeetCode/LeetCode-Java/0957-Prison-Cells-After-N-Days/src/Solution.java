import java.util.Arrays;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }
        // 14 为一个循环，鬼知道我怎么想出来的
        int[][] nCells = new int[(N - 1) % 14 + 1][cells.length];
        nCells[0][0] = 0;
        nCells[0][cells.length - 1] = 0;
        for (int j = 1; j < cells.length - 1; j++) {
            nCells[0][j] = (cells[j - 1] ^ cells[j + 1]) ^ 1;
        }
        for (int i = 1; i < nCells.length; i++) {
            for (int j = 1; j < cells.length - 1; j++) {
                nCells[i][j] = (nCells[i - 1][j - 1] ^ nCells[i - 1][j + 1]) ^ 1;
            }
        }
        return nCells[nCells.length - 1];
    }

    public static void main(String[] args) {
        int[] cells = new int[]{1, 0, 0, 1, 0, 0, 0, 1};
        int[] res = new Solution().prisonAfterNDays(cells, 826);
        System.out.println(Arrays.toString(res));
    }
}