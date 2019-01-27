import java.util.Arrays;

class Solution2 {

    public int coinChange(int[] coins, int amount) {
        // 可以类比于背包问题
        if (amount == 0) {
            return 0;
        }
        int n = coins.length;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            coinChange(coins, amount, i, 0, memo);
        }
        Arrays.sort(memo);
        if (memo[0] == Integer.MAX_VALUE) {
            return -1;
        }
        return memo[0];
    }

    /**
     * 递归答案正确，但超时
     */
    private void coinChange(int[] coins, int amount, int index, int count, int[] memo) {
        amount -= coins[index];
        count++;
        if (amount == 0) {
            if (memo[index] > count) {
                memo[index] = count;
            }
        } else if (amount > 0) {
            for (int i = index; i < coins.length; i++) {
                coinChange(coins, amount, i, count, memo);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2()
                .coinChange(new int[]{186,419,83,408}, 6249));
    }
}