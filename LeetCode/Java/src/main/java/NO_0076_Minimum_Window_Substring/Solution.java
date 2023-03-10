package NO_0076_Minimum_Window_Substring;

class Solution {
    /**
     * 滑动窗口解法
     */
public String minWindow(String s, String t) {
    // tFreq 存储 t 中某个字符出现的次数
    int[] tFreq = new int[128];
    for (char c : t.toCharArray()) {
        tFreq[c]++;
    }
    // start，minLen 用于记录最小子串的位置信息
    int start = 0, minLen = Integer.MAX_VALUE;
    // wFreq 记录 t 中字符在滑动窗口中出现的次数
    int[] wFreq = new int[128];
    // tInWinCnt 表示当前窗口包含 t 中的字符的总数
    int tInWinCnt = 0;
    char[] sChars = s.toCharArray();
    // left，right 为滑动窗口左右边界
    for (int left = 0, right = 0; right < s.length(); right++) {
        char rc = sChars[right];
        if (tFreq[rc] > 0) { // 如果是 t 中字符
            if (++wFreq[rc] <= tFreq[rc]) tInWinCnt++;
        }
        while (tInWinCnt == t.length()) { // 当前窗口包含 t 中所有字符
            int curLen = right - left + 1;
            if (curLen < minLen) {
                start = left;
                minLen = curLen;
            }
            char lc = sChars[left];
            if (tFreq[lc] > 0) { // 如果是 t 中字符
                if (--wFreq[lc] < tFreq[lc]) tInWinCnt--;
            }
            left++;
        }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
}

    public static void main(String[] args) {
        Solution solution = new Solution();
        String minWindow = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(minWindow);
    }
}