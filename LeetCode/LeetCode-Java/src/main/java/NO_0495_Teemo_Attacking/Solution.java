package NO_0495_Teemo_Attacking;

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        // 记录上次攻击所持续到的时间点
        int lastDuration = 0;
        // 遍历攻击时间序列
        for (int n : timeSeries) {
            // 先假设每次攻击都完整有效
            res += duration;
            // 再比较该次攻击的时间点是否处于上次攻击造成的中毒状态中
            if (lastDuration > n) {
                // 减去重合部分
                res -= (lastDuration - n);
            }
            // 更新中毒状态持续时间点
            lastDuration = n + duration;
        }
        return res;
    }
}