package NO_1030_Matrix_Cells_in_Distance_Order;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 距离顺序排列矩阵单元格
 * https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 */
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, List<int[]>> distGroup = new TreeMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dist = Math.abs(i - r0) + Math.abs(j - c0);
                distGroup.computeIfAbsent(dist, k -> new ArrayList<>())
                        .add(new int[]{i, j});
            }
        }
        return distGroup.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .toArray(new int[][]{});
    }

    public int[][] allCellsDitOrder2(int R, int C, int r0, int c0) {
        return IntStream.range(0, R)
                .boxed()
                .flatMap(r -> IntStream.range(0, C).boxed().map(c -> new int[]{r, c}))
                .sorted(Comparator.comparingInt(a -> Math.abs(a[0] - r0) + Math.abs(a[1] - c0)))
                .collect(Collectors.toList())
                .toArray(new int[][]{});
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] res = s.allCellsDitOrder2(2, 3, 1, 2);
        System.out.println("res = " + Arrays.deepToString(res));
    }
}