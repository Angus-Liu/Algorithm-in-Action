package NO_0447_Number_of_Boomerangs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        // 查找表法
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            // 每个点都用一个 map 记录其余点到该点，不同距离（平方代替）出现的频次
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int dist = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                        + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            Set<Integer> keySet = map.keySet();
            for (Integer key: keySet) {
                Integer freq = map.get(key);
                if (freq != 1) {
                    // 表明有两个以上的点到同一点的距离相同，利用组合概率公式 n * (n - 1)，可以容易算出所有可能的结果
                    res += freq * (freq - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numberOfBoomerangs = solution.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}});
        System.out.println(numberOfBoomerangs);
    }
}