package NO_0091_Decode_Ways;

class Solution {

    public int numDecodings(String s) {
        // 寻找最优子结构和重叠子问题，以记忆化搜索或动态规划来解决
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] codes = s.toCharArray();
        int n = codes.length;
        // memo[i] 表示字符串中第 i 位数字与其之后数字的组成的编码总数
        int[] memo = new int[n];
        if (codes[n - 1] != '0') {
            memo[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            // '0' 需要与其前一位一起考虑，不单独考虑
            if (codes[i] == '0') {
                continue;
            }
            // 判断与后面的数字的组合是否小于 26
            if (codes[i] == '1' || (codes[i] == '2' && codes[i + 1] <= '6')) {
                if (i == n - 2) {
                    memo[i] = memo[i + 1] + 1;
                } else {
                    // 以 i 位数字开头的编码总和其实就是其后两位数字各自的编码之和
                    memo[i] = memo[i + 1] + memo[i + 2];
                }
            } else {
                memo[i] = memo[i + 1];
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("0"));
    }
}