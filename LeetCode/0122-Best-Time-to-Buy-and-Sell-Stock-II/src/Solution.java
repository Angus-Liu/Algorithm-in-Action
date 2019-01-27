class Solution {
    public int maxProfit_1(int[] prices) {
        // 贪心算法
        int cost = -1;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (cost == -1) {
                // 在涨价前一天买入股票
                if (i + 1 < prices.length && prices[i + 1] > prices[i]) {
                    cost = prices[i];
                }
            } else {
                // 在降价前一天卖出股票
                if (i == prices.length - 1 || prices[i + 1] < prices[i]) {
                    profit += prices[i] - cost;
                    cost = -1;
                }
            }
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        // 贪心算法 - 由第一种算法简化得来
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 4, 5})); // 4
        System.out.println(new Solution().maxProfit(new int[]{2, 1, 2, 0, 1})); // 2
    }
}