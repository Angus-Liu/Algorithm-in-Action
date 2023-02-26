package NO_0056_Merge_Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int lastIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInts = intervals[lastIndex];
            int[] curInts = intervals[i];
            if (lastInts[1] >= curInts[0]) {
                lastInts[1] = Math.max(curInts[1], lastInts[1]);
            } else {
                intervals[++lastIndex] = curInts;
            }
        }
        return Arrays.copyOf(intervals, lastIndex + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = new int[][]{{1, 2}, {4, 5}};
        int[][] res = s.merge(intervals);
        System.out.println(Arrays.deepToString(res));
    }

}