package NO_0406_Queue_Reconstruction_by_Height;

import java.util.Arrays;

/**
 * 根据身高重建队列
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][];
        // 按身高排序，身高相同时，按排位逆序
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        for (int[] p : people) {
            // 先确定较矮的所在位置，因为剩下的位置就是留给更高的
            for (int i = 0, j = p[1] + 1; i < res.length; i++) {
                if (res[i] != null) continue;
                if (--j != 0) continue;
                res[i] = p;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = s.reconstructQueue(people);
        System.out.println(Arrays.deepToString(res));
    }
}
