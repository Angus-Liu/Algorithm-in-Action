package NO_0973_K_Closest_Points_to_Origin;

import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        List<Integer> disList = new ArrayList<>();

        for (int[] point : points) {
            int dis = point[0] * point[0] + point[1] * point[1];
            List<int[]> pointList = map.getOrDefault(dis, new ArrayList<>());
            pointList.add(point);
            map.put(dis, pointList);
            disList.add(dis);
        }
        Collections.sort(disList);

        int[][] res = new int[K][2];
        int index = 0;
        for (int i = 0; i < K; i++) {
            List<int[]> pointList = map.remove(disList.get(i));
            if (pointList != null) {
                for (int[] point : pointList) {
                    res[index++] = point;
                    if (index >= K) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}