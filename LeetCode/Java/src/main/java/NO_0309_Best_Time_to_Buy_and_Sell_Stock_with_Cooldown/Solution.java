package NO_0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        // hold[i] 表示到第 i 天时，买入所持股票所花费的总额
        int[] hold = new int[n];
        // cash[i] 表示到第 i 天时，抛出股票所赚取的总额
        int[] cash = new int[n];

        hold[0] = prices[0];
        hold[1] = Math.min(hold[0], prices[1]);
        cash[1] = Math.max(cash[0], prices[1] - hold[0]);
        for (int i = 2; i < n; i++) {
            hold[i] = Math.min(hold[i - 1], prices[i] - cash[i - 2]);
            cash[i] = Math.max(cash[i - 1], prices[i] - hold[i - 1]);
        }

        return cash[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}