package JZ_Offer_II_014;

import java.util.Arrays;

class Solution {
    public boolean checkInclusion1(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n2 < n1) return false;

        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }

        char[] chars = s2.toCharArray();
        int l = 0, r = 0;
        int[] win = new int[26];
        while (r < n1 - 1) {
            win[chars[r++] - 'a']++;
        }
        while (r < chars.length) {
            win[chars[r++] - 'a']++;
            if (Arrays.equals(cnt, win)) return true;
            win[chars[l++] - 'a']--;
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n2 < n1) return false;

        int[] cnt = new int[26];
        for (int i = 0; i < n1; i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }
        if (allZero(cnt)) return true;

        for (int i = n1; i < n2; i++) {
            cnt[s2.charAt(i) - 'a']--;
            cnt[s2.charAt(i - n1) - 'a']++;
            if (allZero(cnt)) return true;
        }
        return false;
    }

    private boolean allZero(int[] nums) {
        for (int n : nums) {
            if (n != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.checkInclusion("abc", "eidbdcaoo");
        System.out.println("res = " + res);
    }
}