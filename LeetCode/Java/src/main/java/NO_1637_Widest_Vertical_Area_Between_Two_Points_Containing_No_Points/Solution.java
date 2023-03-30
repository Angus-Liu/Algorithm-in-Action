package NO_1637_Widest_Vertical_Area_Between_Two_Points_Containing_No_Points;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        return Arrays.stream(points)
                .sorted(Comparator.comparingInt(p -> p[0]))
                .reduce(new int[]{Integer.MAX_VALUE, 0}, (pre, cur) ->
                        new int[]{cur[0], Math.max(pre[1], cur[0] - pre[0])}
                )[1];
    }
}
