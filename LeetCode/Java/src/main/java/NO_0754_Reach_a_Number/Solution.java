package NO_0754_Reach_a_Number;

import java.util.Arrays;

/**
 * 到达终点数字
 * https://leetcode-cn.com/problems/reach-a-number/
 */
class Solution {

    /**
     * 一股脑往右走，当发现走过了的时候，如果多走的距离刚好除以2，
     * 说明之前走的某一步往左就可以，否者继续往右走，直到满足这个条件
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        for (int i = 1, sum = 1; ; i++, sum += i) {
            if (sum >= target && (sum - target) % 2 == 0) return i;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100).forEach(target ->
                System.out.println(solution.reachNumber(target))
        );
    }
}
