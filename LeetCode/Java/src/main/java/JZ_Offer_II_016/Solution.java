package JZ_Offer_II_016;

class Solution {


    /**
     * 滑动窗口算法
     */
    public int lengthOfLongestSubstring(String s) {
        boolean[] win = new boolean[128];
        int maxLen = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (win[c]) {
                win[s.charAt(l++)] = false;
            }
            win[c] = true;
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring("pwwkewa");
        System.out.println("res = " + res);
    }
}
