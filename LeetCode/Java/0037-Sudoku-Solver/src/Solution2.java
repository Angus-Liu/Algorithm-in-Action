import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {

    private List<char[][]> res = new ArrayList<>();

    public List<char[][]> solveSudoku(char[][] board) {
        /**
         * 记录某行，某位数字是否已经被摆放
         */
        boolean[][] row = new boolean[9][10];
        /**
         * 记录某列，某位数字是否已经被摆放
         */
        boolean[][] col = new boolean[9][10];
        /**
         * 记录某 3x3 宫格内，某位数字是否已经被摆放
         */
        boolean[][] block = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    // blockIndex = i / 3 * 3 + j / 3，取整
                    block[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board, row, col, block, 0, 0);
        return res;
    }

    private void dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        // 找寻空位置
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            // 没有空位置，即代表已得到数组的一种解
            if (i >= 9) {
                // 拷贝
                char[][] copy = new char[9][9];
                for (int k = 0; k < 9; k++) {
                    copy[k] = Arrays.copyOf(board[k], 9);
                }
                res.add(copy);
                return;
            }
        }
        for (int num = 1; num <= 9; num++) {
            int blockIndex = i / 3 * 3 + j / 3;
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                // 递归
                board[i][j] = (char) ('0' + num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                dfs(board, row, col, block, i, j);
                // 回溯
                row[i][num] = false;
                col[j][num] = false;
                block[blockIndex][num] = false;
                board[i][j] = '.';
            }
        }
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '.', '3', '.', '7', '.', '.', '.', '.'},
                {'.', '8', '.', '.', '9', '5', '.', '.', '.'},
                {'.', '7', '.', '.', '.', '.', '.', '6', '.'},
                {'2', '.', '4', '.', '6', '.', '.', '.', '3'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution2 solution = new Solution2();
        List<char[][]> res = solution.solveSudoku(board);
        for (char[][] r : res) {
            solution.printBoard(r);
            System.out.println("--------------------");
        }
    }
}