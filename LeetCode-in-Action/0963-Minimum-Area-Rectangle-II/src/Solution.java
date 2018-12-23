import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    private Map<Integer, Set<Integer>> map;

    public double minAreaFreeRect(int[][] points) {
        map = new HashMap<>();
        for (int[] point : points) {
            Set<Integer> ySet = map.getOrDefault(point[0], new HashSet<>());
            ySet.add(point[1]);
            map.put(point[0], ySet);
        }
        System.out.println(map);
        // 构成矩形的四个点的坐标必然只能是 x1、x2、y1、y2
        // 先找到对角线的两个点，再看另外两个点是否存在
        double res = Double.MAX_VALUE;
        int x1, y1, x2, y2;
        for (int[] point1 : points) {
            x1 = point1[0];
            y1 = point1[1];
            for (int[] point2 : points) {
                if (point1 != point2) {
                    x2 = point2[0];
                    y2 = point2[1];
                    if (y1 != y2) {
                        // 再看另外两个点是否存在（另一条对角线或是平行线）
                        if (contain(x1, y2) && contain(x2, y1)) {
                            System.out.println("[" + x1 + "," + y1 + "] [" + x1 + "," + y2 + "] [" + x2 + "," + y2 + "] [" + x2 + "," + y1 + "]");
                            res = Math.min(res, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean contain(int x, int y) {
        Set<Integer> ySet = map.get(x);
        if (ySet != null && ySet.contains(y)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minAreaFreeRect(new int[][]{{3, 1}, {1, 1}, {0, 1}, {2, 1}, {3, 3}, {3, 2}, {0, 2}, {2, 3}}));
    }
}