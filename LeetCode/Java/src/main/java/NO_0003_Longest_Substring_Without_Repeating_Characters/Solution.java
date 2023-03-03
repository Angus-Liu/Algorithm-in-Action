package NO_0003_Longest_Substring_Without_Repeating_Characters;

class Solution {

    /**
     * 滑动窗口解法
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        // flags 用于表明滑动窗口是否包含某个字符
        boolean[] flags = new boolean[256];
        // 滑动窗口为 s[l, r]，r = -1，表示窗口初始大小为 0
        int l = 0, r = -1;
        int maxLen = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && !flags[s.charAt(r + 1)]) {
                // 右边界的下一个元素未在窗口中出现过，就加入到窗口中
                flags[s.charAt(++r)] = true;
            } else {
                // 否则，就将窗口右移动，直到把重复元素移出去为止
                flags[s.charAt(l++)] = false;
            }
            maxLen = Math.max(r - l + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int len = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(len);
        len = solution.lengthOfLongestSubstring("bbbbbb");
        System.out.println(len);
    }
}