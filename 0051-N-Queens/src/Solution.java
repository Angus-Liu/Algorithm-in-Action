import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private List<List<String>> res = new ArrayList<>();

    /**
     * 记录某列是否已有皇后摆放（某列即对应待摆放位置的 x 坐标）
     */
    private boolean col[];

    /**
     * 记录某条正对角线（左上右下方向）是否已有皇后摆放（某条对应待摆放位置的 x - y + n - 1）
     */
    private boolean dia1[];

    /**
     * 记录某条斜对角线（左下右上方向）是否已有皇后摆放（某条对应待摆放位置的 x + y）
     */
    private boolean dia2[];

    public List<List<String>> solveNQueens(int n) {
        // 利用递归回溯的思路解题
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        int[] row = new int[n];
        putQueen(n, 0, row);
        return res;
    }

    /**
     * 递归回溯的方式摆放皇后
     *
     * @param n     待摆放皇后个数
     * @param index 已摆放皇后个数
     * @param row   存储皇后在该行摆放的列坐标
     */
    private void putQueen(int n, int index, int[] row) {
        // 皇后以摆放完毕，找到了一个解
        if (index == n) {
            res.add(generateBoard(row));
            return;
        }
        // 表示在 index 的第 i 列尝试摆放皇后
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[i - index + n - 1] && !dia2[i + index]) {
                // 递归
                row[index] = i;
                col[i] = true;
                dia1[i - index + n - 1] = true;
                dia2[i + index] = true;
                putQueen(n, index + 1, row);
                // 回溯
                col[i] = false;
                dia1[i - index + n - 1] = false;
                dia2[i + index] = false;
            }
        }
    }

    /**
     * 根据行列坐标值，生成皇后摆放矩阵
     *
     * @param row
     * @return
     */
    private List<String> generateBoard(int[] row) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            char[] charArray = new char[row.length];
            Arrays.fill(charArray, '.');
            charArray[row[i]] = 'Q';
            board.add(String.valueOf(charArray));
        }
        return board;
    }

    public static void main(String[] args) {
        List<List<String>> nQueensBoard = new Solution().solveNQueens(8);
        nQueensBoard.forEach(
                queensBoard -> {
                    System.out.println();
                    queensBoard.forEach(System.out::println);
                }
        );
    }
}