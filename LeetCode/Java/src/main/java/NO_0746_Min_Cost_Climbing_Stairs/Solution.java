package NO_0746_Min_Cost_Climbing_Stairs;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int pre = cost[0], cur = cost[1], next;
        for (int i = 2; i < cost.length; i++) {
            next = cost[i] + Math.min(pre, cur);
            pre = cur;
            cur = next;
        }
        return Math.min(pre, cur);
    }
}
