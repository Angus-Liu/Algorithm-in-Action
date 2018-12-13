class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length < 2) {
            return maxProfit;
        }
        int minCost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minCost);
            minCost = Math.min(minCost, prices[i]);
        }
        return maxProfit;
    }
}