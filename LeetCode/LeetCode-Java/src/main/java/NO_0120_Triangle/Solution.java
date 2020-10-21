package NO_0120_Triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minimumTotal1(List<List<Integer>> triangle) {

        //    [2],      0
        //   [3,4],    1 2
        //  [6,5,7],  3 4 5
        // [4,1,8,3] 6 7 8 9
        //
        // 规律：
        // ① 金字塔中的每一项的坐标，由公式 i = n + n*(n-1)/2 + index 得到，n 为行数，index 为该项在该行的索引
        // ① 第 n 层，头只有右相邻顶节点，尾只有左相邻顶点
        // ② 第 n 层，第 i 项的左相邻顶点为，为第 i-(n+1) 项，右相邻顶节点为第 i-n 项（i，n 均从 0 开始计数）
        // PS：等差数列求和公式 Sn = n*a1 + [n*(n-1)/2]*d

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int row = triangle.size();
        if (row == 1) {
            return triangle.get(0).get(0);
        }
        // memo 数组用于存储每层每个数字到塔尖的最短路径
        int size = row + row * (row - 1) / 2;
        int[] memo = new int[size];
        memo[0] = triangle.get(0).get(0);
        memo[1] = triangle.get(1).get(0) + memo[0];
        memo[2] = triangle.get(1).get(1) + memo[0];
        for (int i = 2; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                // 原值
                int val = triangle.get(i).get(j);
                int index = i + i * (i - 1) / 2 + j;
                int leftUp = index - i - 1;
                int rightUp = leftUp + 1;
//                System.out.println("index:" + index + " -> leftUp:" + leftUp + " -> rightUp:" + rightUp);
                if (j == 0) {
                    // 每行第一项只有右上
                    memo[index] = val + memo[rightUp];
                } else if (j == i) {
                    // 每行最后一项只有左上
                    memo[index] = val + memo[leftUp];
                } else {
                    // 其余项，需要从与左上及右上中选一个最小值
                    memo[index] = val + Math.min(memo[leftUp], memo[rightUp]);
                }
            }
        }
        // 遍历 triangle 中对应 memo 最后一行，得出最小值
        int res = memo[size - 1];
        for (int i = size - 2; i >= size - row; i--) {
            res = res > memo[i] ? memo[i] : res;
        }
        return res;
    }

    /**
     * 简化版
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        for (int i = 1; i < row; i++) {
            triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i - 1).get(0));
            triangle.get(i).set(i, triangle.get(i).get(i) + triangle.get(i - 1).get(i - 1));
            for (int j = 1; j < i; j++) {
                int min = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        return Collections.min(triangle.get(row - 1));
    }


    public static void main(String[] args) {
        int[][] triangleArray =
                new int[][]{
                        {2},
                        {3, 4},
                        {6, 5, 7},
                        {4, 1, 8, 3}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (int[] row : triangleArray) {
            List<Integer> list = new ArrayList<>();
            for (int e : row) {
                list.add(e);
            }
            triangle.add(list);
        }
//        System.out.println(triangle);
        System.out.println(new Solution().minimumTotal(triangle));
    }
}