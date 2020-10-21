package NO_0392_Is_Subsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        // 贪心算法
        int si = 0;
        int ti = 0;
        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
            } else {
                ti++;
            }
        }
        return si == s.length();
    }
}