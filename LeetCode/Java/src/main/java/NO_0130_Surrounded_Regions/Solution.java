package NO_0130_Surrounded_Regions;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    /**
     * 偏移量数组，用来计算指定坐标坐标相邻的上下左右的坐标
     */
    private int[][] d = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    /**
     * 访问标志数组，用来记录指定位置字母是否被访问过
     */
    private boolean[][] visited;

    /**
     * key - x, value - y
     */
    private List<Pair<Integer, Integer>> records = new ArrayList<>();

    private int r;

    private int l;

    public void solve(char[][] board) {
        // 深度优先遍历、广度优先遍历均可，只要 O 所在的区域最后到不了边界，就是要被翻转为 X
        if (board == null || board.length == 0) {
            return;
        }
        r = board.length;
        l = board[0].length;
        visited = new boolean[r][l];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] == 'O' && !visited[y][x]) {
                    if (dfs(board, x, y)) {
                        // 未访问到边界，需要翻转
                        for (Pair<Integer, Integer> record : records) {
                            board[record.getValue()][record.getKey()] = 'X';
                        }
                    }
                    records.clear();
                }
            }
        }
    }

    private boolean dfs(char[][] board, int x, int y) {
        boolean surrounded = true;
        visited[y][x] = true;
        records.add(new Pair<>(x, y));
        // 当遍历到边界时，证明该区域未被包围
        if (x == 0 || x == l - 1 || y == 0 || y == r - 1) {
            surrounded = false;
        }
        for (int i = 0; i < d.length; i++) {
            int nextX = x + d[i][0];
            int nextY = y + d[i][1];
            if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < r
                    && board[nextY][nextX] == 'O' && !visited[nextY][nextX]) {
                if (!dfs(board, nextX, nextY)) {
                    surrounded = false;
                }

            }
        }
        return surrounded;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        new Solution().solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}