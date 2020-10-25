package NO_0292_Nim_Game;

/**
 * Nim 游戏
 * https://leetcode-cn.com/problems/nim-game/
 */
class Solution {
    public boolean canWinNim(int n) {
        // 巴什博奕
        return n % 4 != 0;
    }
}