package NO_0079_Word_Search;

class Solution {
    /**
     * 偏移量数组，用来计算指定坐标坐标相邻的上下左右的坐标
     */
    private int[][] d = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    /**
     * 访问标志数组，用来记录指定位置字母是否被访问过
     */
    private boolean[][] visited;

    private int r;

    private int l;

    public boolean exist(char[][] board, String word) {
        // 深度搜索
        r = board.length;
        l = board[0].length;
        visited = new boolean[r][l];
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < l; x++) {
                if (searchWord(board, word, 0, x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int x, int y) {
        // 匹配到 word 最后一个字母
        if (index == word.length() - 1) {
            return board[y][x] == word.charAt(index);
        }
        // 当前字母匹配成功，准备从当前字母出发，匹配下一个字母
        if (board[y][x] == word.charAt(index)) {
            // 递归
            visited[y][x] = true;
            // 遍历当前字母的四个方位
            for (int i = 0; i < d.length; i++) {
                int nextX = x + d[i][0];
                int nextY = y + d[i][1];
                // 确保合法以及未访问
                if (0 <= nextX && nextX < l && 0 <= nextY && nextY < r && !visited[nextY][nextX]) {
                    if (searchWord(board, word, index + 1, nextX, nextY)) {
                        return true;
                    }
                }
            }
            // 回溯
            visited[y][x] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}