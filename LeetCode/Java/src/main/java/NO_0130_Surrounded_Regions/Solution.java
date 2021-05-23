package NO_0130_Surrounded_Regions;

import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * 偏移量数组，用来计算指定坐标坐标相邻的上下左右的坐标
     */
    private final int[][] offsets = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    /**
     * 访问标志数组，用来记录指定位置字母是否被访问过
     */
    private boolean[][] visited;

    /**
     * key - x, value - y
     */
    private final List<Pair<Integer, Integer>> records = new ArrayList<>();

    private int rows;

    private int cols;

    public void solve(char[][] board) {
        // 深度优先遍历、广度优先遍历均可，只要 O 所在的区域最后到不了边界，就是要被翻转为 X
        if (board == null || board.length == 0) return;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
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
        if (x == 0 || x == cols - 1 || y == 0 || y == rows - 1) {
            surrounded = false;
        }
        for (int[] o : offsets) {
            int nextX = x + o[0];
            int nextY = y + o[1];
            if (nextX >= 0 && nextX < cols
                    && nextY >= 0 && nextY < rows
                    && board[nextY][nextX] == 'O'
                    && !visited[nextY][nextX]) {
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
                {'X', 'O', 'X', 'X'}
        };
        new Solution().solve(board);
        for (char[] rows : board) {
            System.out.println(rows);
        }
    }
}