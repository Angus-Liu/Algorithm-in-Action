package NO_0057_Insert_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 插入区间
 * https://leetcode-cn.com/problems/insert-interval/
 */
class Solution {
    // TODO: angus on 2020/11/4 
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer> endpoints = new ArrayList<>();
        for (int[] interval : intervals) {
            endpoints.add(interval[0]);
            endpoints.add(interval[1]);
        }
        boolean hasOverlapping = false;
        for (Iterator<Integer> it = endpoints.iterator(); it.hasNext(); ) {
            Integer endPoint = it.next();
            if (endPoint >= newInterval[0] && endPoint <= newInterval[1]) {
                it.remove();
                hasOverlapping = true;
            }
        }
        if (!hasOverlapping) {
            endpoints.add(newInterval[0]);
            endpoints.add(newInterval[1]);
        }
        int[][] newIntervals = new int[endpoints.size() / 2][2];
        for (int i = 0; i < endpoints.size(); i++) {
            newIntervals[i / 2][i % 2] = endpoints.get(i);
        }
        return newIntervals;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        int[][] res = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(res));
    }
}