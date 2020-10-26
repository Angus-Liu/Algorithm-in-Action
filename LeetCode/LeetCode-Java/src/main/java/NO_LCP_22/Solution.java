package NO_LCP_22;

/**
 * 黑白方格画
 * https://leetcode-cn.com/problems/ccw6C7/
 */
public class Solution {
    
    // TODO: angus on 2020/10/26
    // 还需阅读 https://leetcode-cn.com/problems/ccw6C7/solution/shu-xue-tui-dao-by-sunrise-z/
    public int paintingPlan(int n, int k) {
        if (k == 0 || k == n * n) return 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (n * (i + j) - (i * j) == k) {
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
        System.out.println(s.paintingPlan(1, 1));
    }
}
