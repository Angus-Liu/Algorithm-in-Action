package JZ_Offer_II_035;

import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) return 0;
        boolean[] minuteFlags = new boolean[1440];
        int first = 1440, last = -1;
        for (String timePoint : timePoints) {
            String[] t = timePoint.split(":");
            int minute = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            if (minuteFlags[minute]) {
                return 0;
            }
            minuteFlags[minute] = true;
            first = Math.min(first, minute);
            last = Math.max(last, minute);
        }
        int minDiff = first + (1440 - last);
        for (int prev = first, cur = first + 1; cur <= last; cur++) {
            if (minuteFlags[cur]) {
                minDiff = Math.min(minDiff, cur - prev);
                prev = cur;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        List<String> timePoints = List.of("01:01", "02:01", "03:00");
        Solution solution = new Solution();
        int res = solution.findMinDifference(timePoints);
        System.out.println(res);
    }
}
