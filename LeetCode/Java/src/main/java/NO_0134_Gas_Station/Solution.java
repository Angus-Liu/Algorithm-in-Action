package NO_0134_Gas_Station;

/**
 * 加油站
 * https://leetcode-cn.com/problems/gas-station/
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 走完全程剩余汽油
        int restGas = 0;
        // 当前油箱汽油
        int curGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            restGas += gas[i] - cost[i];
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                start = i + 1;
                curGas = 0;
            }
        }
        return restGas >= 0? start : -1;
    }
}