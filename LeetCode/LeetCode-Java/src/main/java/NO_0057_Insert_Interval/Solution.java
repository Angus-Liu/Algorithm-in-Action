package NO_0057_Insert_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 插入区间
 * https://leetcode-cn.com/problems/insert-interval/
 */
class Solution {

    /**
     * 将 newInterval 与 intervals 逐一比较，如果有交集，就合成新的 newInterval，
     * 没有交集直接方到结果集中，最后把 newInterval 也加入，排序后输出
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (hasOverlapping(interval, newInterval)) {
                newInterval = mergeInterval(interval, newInterval);
            } else {
                res.add(interval);
            }
        }
        res.add(newInterval);
        res.sort(Comparator.comparingInt(i -> i[0]));
        int[][] newIntervals = new int[res.size()][2];
        return res.toArray(newIntervals);
    }

    /**
     * 判断是否有交集
     */
    private boolean hasOverlapping(int[] i1, int[] i2) {
        return i1[0] <= i2[1] && i1[1] >= i2[0];
    }

    /**
     * 将两个 interval 合成一个
     */
    private int[] mergeInterval(int[] i1, int[] i2) {
        return new int[]{
                Math.min(i1[0], i2[0]),
                Math.max(i1[1], i2[1])
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 4};
        int[][] res = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(res));

        int[][] intervals2 = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = new int[]{4, 8};
        int[][] res2 = solution.insert(intervals2, newInterval2);
        System.out.println(Arrays.deepToString(res2));
    }
}