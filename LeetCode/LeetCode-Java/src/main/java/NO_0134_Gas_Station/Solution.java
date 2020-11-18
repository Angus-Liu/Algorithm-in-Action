package NO_0134_Gas_Station;

/**
 * 加油站
 * https://leetcode-cn.com/problems/gas-station/
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int restGas = 0;
        int costGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            restGas += gas[i] - cost[i];
            costGas += gas[i] - cost[i];
            if (costGas < 0) {
                start = i + 1;
                costGas = 0;
            }
        }
        return restGas >= 0? start : -1;
    }
}