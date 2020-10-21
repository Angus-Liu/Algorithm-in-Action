package NO_0322_Coin_Change;

import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        // 动态规划
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution()
                .coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Solution()
                .coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}