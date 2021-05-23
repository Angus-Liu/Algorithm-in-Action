package NO_0149_Max_Points_on_a_Line;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        // TODO: 查找表法
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int samePoint = 1;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoint++;
                } else if (points[i].x == points[j].x) {
                    map.put(Double.MAX_VALUE,
                            map.getOrDefault(Double.MAX_VALUE, 0) + 1);
                } else {
                    double slope = (double) (points[i].y - points[j].y) / (points[i].x - points[j].x);
                    map.put(slope,
                            map.getOrDefault(slope, 0) + 1);
                }
            }
            AtomicInteger localMax = new AtomicInteger();
            map.forEach((slop, count) -> {
                localMax.set(Math.max(localMax.get(), count));
            });
            res = Math.max(res, localMax.get() + samePoint);
        }
        return res;
    }

}