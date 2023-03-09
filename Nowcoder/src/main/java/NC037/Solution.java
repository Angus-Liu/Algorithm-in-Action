package NC037;

import java.util.*;

/**
 * NC37 合并区间
 *
 * @Site <a href="https://www.nowcoder.com/practice/69f4e5b7ad284a478777cb2a17fb5e6a"/>
 */
public class Solution {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int n = intervals.size();
        if (n <= 1) return intervals;
        ArrayList<Interval> res = new ArrayList<>();

        // [0, 10], [10, 15], [10, 20]
        intervals.sort(Comparator.comparingInt(i -> i.start));

        Interval a = intervals.get(0);
        for (int j = 1; j < n; j++) {
            Interval b = intervals.get(j);
            if (a.end >= b.start)  {
                a.end = Math.max(a.end, b.end);
            } else {
                res.add(a);
                a = b;
            }
        }
        res.add(a);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Interval> intervals = Interval.of(new int[][]{{10, 30}, {20, 60}, {80, 100}, {150, 180}});
        ArrayList<Interval> res = solution.merge(intervals);
        System.out.println(res);
    }
}
