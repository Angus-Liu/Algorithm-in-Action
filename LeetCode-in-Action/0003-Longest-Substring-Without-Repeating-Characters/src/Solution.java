class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 滑动窗口解法
        // freq 用于存储滑动窗口中某个字符出现的次数
        int freq[] = new int[256];
        // 滑动窗口为 s[l, r]
        int l = 0;
        // r = -1，表示窗口初始大小为 0
        int r = -1;
        int len = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                // 右边界的下一个元素未在窗口中出现过，就加入到窗口中
                r++;
                freq[s.charAt(r)]++;
            } else {
                // 否则，就将窗口右移动，直到把重复元素移出去为止
                freq[s.charAt(l)]--;
                l++;
            }
            len = r - l + 1 > len ? r - l + 1 : len;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int len = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(len);
        len = solution.lengthOfLongestSubstring("bbbbbb");
        System.out.println(len);
    }
}