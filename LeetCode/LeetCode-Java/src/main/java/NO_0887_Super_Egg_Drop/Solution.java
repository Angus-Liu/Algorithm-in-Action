package NO_0887_Super_Egg_Drop;

class Solution {
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int m;
        for (m = 0; dp[K] < N; m++) {
            for (int i = K; i > 0; i--) {
                dp[i] += dp[i - 1] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int res = new Solution().superEggDrop(2, 14);
        System.out.println("res = " + res);
    }
}