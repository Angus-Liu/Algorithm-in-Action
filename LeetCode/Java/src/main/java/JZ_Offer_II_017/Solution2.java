package JZ_Offer_II_017;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public String minWindow1(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        }
        int minL = 0;
        int minR = Integer.MAX_VALUE;
        int diff = t.length();
        Map<Character, Integer> win = new HashMap<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            win.merge(rc, 1, Integer::sum);
            if (win.get(rc) <= freq.getOrDefault(rc, 0)) {
                diff--;
            }
            while (diff == 0) {
                if (r - l < minR - minL) {
                    minL = l;
                    minR = r;
                }
                char lc = s.charAt(l);
                win.merge(lc, -1, Integer::sum);
                if (win.get(lc) < freq.getOrDefault(lc, 0)) {
                    diff++;
                }
                l++;
            }
        }
        return minR == Integer.MAX_VALUE ? "" : s.substring(minL, minR + 1);
    }

    public String minWindow(String s, String t) {
        // 如果 s 的长度小于 t 的长度，直接返回空字符串
        if (s.length() < t.length()) return "";
        // 初始化字符频率数组和 diff 计数器
        int diff = 0;
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            if (++freq[c] == 1) diff++;
        }
        // 初始化最小窗口的左右边界和窗口字符频率数组
        int minL = 0, minR = Integer.MAX_VALUE;
        int[] win = new int[128];
        // 遍历 s 中的字符
        for (int l = 0, r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            // 更新窗口字符频率数组和 diff 计数器
            if (++win[rc] == freq[rc]) diff--;
            // 当窗口包含 t 中的所有字符时，收缩窗口
            while (diff == 0) {
                if (r - l < minR - minL) {
                    minL = l;
                    minR = r;
                }
                char lc = s.charAt(l++);
                if (--win[lc] < freq[lc]) diff++;
            }
        }
        // 如果没有找到最小窗口，返回空字符串；否则返回最小窗口对应的子字符串
        return minR == Integer.MAX_VALUE ? "" : s.substring(minL, minR + 1);
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String res = solution.minWindow("ADOBECODEBCADNC", "ABCD");
        System.out.println("res = " + res);
    }
}
