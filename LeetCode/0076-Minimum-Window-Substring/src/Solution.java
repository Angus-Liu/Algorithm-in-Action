class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // 滑动窗口解法
        // tFreq，windowFreq 分别用于存储 p 和滑动窗口中某个字符出现的次数
        int[] tFreq = new int[256];
        int[] windowFreq = new int[256];
        // 初始化 tFreq
        for (int i = 0; i < tChars.length; i++) {
            tFreq[tChars[i]]++;
        }
        // minSize，minL，minR 用于记录最小子串的位置信息
        int minSize = sChars.length + 1;
        int minL = -1;
        int minR = -1;
        // 滑动窗口左右边界，初始值为空集
        int l = 0;
        int r = -1;
        while (l < sChars.length - tChars.length + 1) {
            if (r - l + 1 < tChars.length) {
                if (r + 1 < sChars.length) {
                    windowFreq[sChars[++r]]++;
                } else {
                    break;
                }
            } else {
                if (isMatch(tChars, windowFreq, tFreq)) {
                    if (minSize > r - l + 1) {
                        minSize = r - l + 1;
                        minL = l;
                        minR = r;
                    }
                    // 匹配上之后，窗口左边界右移，缩小窗口大小
                    windowFreq[sChars[l++]]--;
                } else {
                    if (r + 1 < sChars.length) {
                        windowFreq[sChars[++r]]++;
                    } else {
                        break;
                    }
                }
            }
        }
        if (minL == -1 || minR == -1) {
            return "";
        }
        return s.substring(minL, minR + 1);
    }

    /**
     * 检查 t 中所有字符是否都在滑动窗口中
     *
     * @param tChars
     * @param windowFreq
     * @param tFreq
     * @return
     */
    private boolean isMatch(char[] tChars, int[] windowFreq, int[] tFreq) {
//        System.out.println("----------");
//        for (int i = 0; i < tChars.length; i++) {
//            System.out.println("freq[" + tChars[i] + "]: " + windowFreq[tChars[i]]);
//        }
        for (int i = 0; i < tChars.length; i++) {
            if (windowFreq[tChars[i]] < tFreq[tChars[i]]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String minWindow = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(minWindow);
    }
}