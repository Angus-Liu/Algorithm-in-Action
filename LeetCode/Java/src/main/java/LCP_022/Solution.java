package LCP_022;

/**
 * 黑白方格画
 * https://leetcode-cn.com/problems/ccw6C7/
 */
class Solution {
    public int paintingPlan(int n, int k) {
        if (k == 0 || k == n * n) return 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 如果 i 行 j 列均涂黑后，减去相交部分等于 k，则符合条件
                if (n * (i + j) - (i * j) == k) {
                    // 从 n 行中任意取 i 行 * 从 n 列中任意取 j 列
                    res += combination(n, i) * combination(n, j);
                }
            }
        }
        return res;
    }

    public int combination(int n, int a) {
        return factorial(n) / (factorial(a) * factorial(n - a));
    }

    public int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.paintingPlan(2, 1));
        System.out.println(s.paintingPlan(2, 2));
        System.out.println(s.paintingPlan(2, 4));
        System.out.println(s.paintingPlan(4, 4));
    }
}
