package JZ_Offer_II_015;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return res;

        int[] cnt = new int[26];
        int[] win = new int[26];
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        for (int i = 0; i < pLen; i++) {
            win[sChars[i] - 'a']++;
            cnt[pChars[i] - 'a']++;
        }
        if (isSame(cnt, win, sChars[pLen - 1] - 'a')) {
            res.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            win[sChars[i - pLen] - 'a']--;
            win[sChars[i] - 'a']++;
            if (isSame(cnt, win, sChars[i] - 'a')) {
                res.add(i - pLen + 1);
            }
        }
        return res;
    }

    private boolean isSame(int[] a, int[] b, int first) {
        if (a[first] != b[first]) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.findAnagrams("cbaebabacd", "bac");
        System.out.println("res = " + res);
    }
}