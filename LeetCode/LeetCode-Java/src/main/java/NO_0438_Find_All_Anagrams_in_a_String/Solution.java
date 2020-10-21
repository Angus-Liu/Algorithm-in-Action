package NO_0438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramIndexes = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
            return anagramIndexes;
        }
        // 滑动窗口解法
        // pFreq，windowFreq 分别用于存储 p 和滑动窗口中某个字符出现的次数
        int[] pFreq = new int[256];
        int[] windowFreq = new int[256];
        // 滑动窗口为 s[l, r], p 的长度就是滑动窗口的大小
        int l = 0;
        int r = p.length() - 1;
        for (int i = 0; i <= r; i++) {
            ++pFreq[p.charAt(i)];
            ++windowFreq[s.charAt(i)];
        }
        if (isMatch(windowFreq, p, pFreq)) {
            anagramIndexes.add(l);
        }
        while (l < s.length() && r + 1 < s.length()) {
            // 窗口整体右移一格
            windowFreq[s.charAt(++r)]++;
            windowFreq[s.charAt(l++)]--;
            if (isMatch(windowFreq, p, pFreq)) {
                anagramIndexes.add(l);
            }
        }
        return anagramIndexes;
    }

    /**
     * 检查 p 中所有字符是否都在滑动窗口中
     *
     * @param windowFreq
     * @param p
     * @param pFreq
     * @return
     */
    private boolean isMatch(int[] windowFreq, String p, int[] pFreq) {
//        System.out.println("----------");
//        for (int i = 0; i < p.length(); i++) {
//            System.out.println("freq[" + p.charAt(i) + "]: " + windowFreq[p.charAt(i)]);
//        }
        for (int i = 0; i < p.length(); i++) {
            if (windowFreq[p.charAt(i)] != pFreq[p.charAt(i)]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> anagramIndexes = solution.findAnagrams("abab", "ab");
        System.out.println(anagramIndexes);
        anagramIndexes = solution.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagramIndexes);
        anagramIndexes = solution.findAnagrams("baa", "aa");
        System.out.println(anagramIndexes);
    }
}