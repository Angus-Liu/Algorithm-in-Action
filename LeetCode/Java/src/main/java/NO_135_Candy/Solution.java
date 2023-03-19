package NO_135_Candy;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] leftCandies = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                leftCandies[i] = leftCandies[i - 1] + 1;
            } else {
                leftCandies[i] = 1;
            }
        }
        int rightCandy = 0, candySum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                rightCandy++;
            } else {
                rightCandy = 1;
            }
            candySum += Math.max(leftCandies[i], rightCandy);
        }
        return candySum;
    }
}
