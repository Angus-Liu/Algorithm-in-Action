package NO_0827_Making_A_Large_Island;

import java.util.*;

class Solution {
    private int N = 0;
    private final int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 遍历 grid，通过 DFS 或者 BFS 记录 grid[i][j] 所属岛屿编号及其面积。再次遍历，在可连通处，
     * 即 grid[i][j] == 0 且其上下左右存在岛屿时，计算连通后的岛屿面积，留下最大的
     */
    public int largestIsland(int[][] grid) {
        N = grid.length;
        int maxArea = 0;
        // 当前岛屿对应编号
        int curIdx = 0;
        // 用于记录 grid[i][j] 所在岛屿编号
        int[][] idxOfGrid = new int[N][N];
        // 记录每个岛屿的面积，为方便后续条件判断，将 0 号岛屿设为虚拟岛屿，面积为 0
        List<Integer> areas = new ArrayList<>();
        areas.add(0);
        // 计算现有岛屿面积，并记录 grid 所属岛屿编号
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1 && idxOfGrid[i][j] == 0) {
                    curIdx++;
                    // DFS
                    int curArea = calAreaByDFS(grid, i, j, idxOfGrid, curIdx);
                    // BFS
                    // int curArea = calAreaByBFS(grid, i, j, idxOfGrid, curIdx);
                    areas.add(curArea);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        // 计算某点连通后的岛屿面积
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    maxArea = Math.max(maxArea, connectedArea(grid, i, j, idxOfGrid, areas));
                }
            }
        }
        return maxArea;
    }

    /**
     * 通过 DFS 计算当前 grid 所属岛屿面积，并标记 grid 所属岛屿编号
     */
    private int calAreaByDFS(int[][] grid, int r, int c, int[][] idxOfGrid, int curIdx) {
        int area = 1;
        idxOfGrid[r][c] = curIdx;
        for (int[] v : vector) {
            int _r = r + v[0];
            int _c = c + v[1];
            if (_r >= 0 && _r < N && _c >= 0 && _c < N
                    && grid[_r][_c] == 1
                    && idxOfGrid[_r][_c] == 0) {
                area += calAreaByDFS(grid, _r, _c, idxOfGrid, curIdx);
            }
        }
        return area;
    }

    static class Pair {
        public int row, col;

        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    /**
     * 通过 BFS 计算当前 grid 所属岛屿面积，并标记 grid 所属岛屿编号
     */
    private final Deque<Pair> gridStack = new LinkedList<>();

    private int calAreaByBFS(int[][] grid, int r, int c, int[][] idxOfGrid, int curIdx) {
        int area = 1;
        gridStack.add(new Pair(r, c));
        idxOfGrid[r][c] = curIdx;
        while (!gridStack.isEmpty()) {
            Pair p = gridStack.removeLast();
            for (int[] v : vector) {
                int _r = p.row + v[0];
                int _c = p.col + v[1];
                if (_r >= 0 && _r < N && _c >= 0 && _c < N
                        && grid[_r][_c] == 1
                        && idxOfGrid[_r][_c] == 0) {
                    area++;
                    idxOfGrid[_r][_c] = curIdx;
                    gridStack.add(new Pair(_r, _c));
                }
            }
        }

        return area;
    }

    /**
     * 返回 grid[r][c] 变为 1 后所连通岛屿的面积
     */
    private final Set<Integer> idxSet = new HashSet<>();

    private int connectedArea(int[][] grid, int r, int c, int[][] idxOfGrid, List<Integer> areas) {
        int area = 1;
        // 搜索上下左右四个方向，若有未连接的岛屿，将其面积计入连接后的岛屿面积中
        for (int[] v : vector) {
            int _r = r + v[0];
            int _c = c + v[1];
            if (_r >= 0 && _r < N && _c >= 0 && _c < N && grid[_r][_c] == 1) {
                int idx = idxOfGrid[_r][_c];
                if (idxSet.contains(idx)) continue;
                area += areas.get(idx);
                idxSet.add(idx);
            }
        }
        idxSet.clear();
        return area;
    }
}