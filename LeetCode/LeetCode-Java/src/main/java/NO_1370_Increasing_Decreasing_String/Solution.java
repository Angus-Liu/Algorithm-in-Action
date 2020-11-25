package NO_1370_Increasing_Decreasing_String;

/**
 * 上升下降字符串
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 */
class Solution {
    public String sortString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        while (res.length() < s.length()) {
            StringBuilder sub = new StringBuilder();
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > 0) {
                    res.append((char) ('a' + i));
                    freq[i]--;
                }
                if (freq[i] > 0) {
                    sub.append((char) ('a' + i));
                    freq[i]--;
                }
            }
            if (sub.length() > 0) {
                res.append(sub.reverse());
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.sortString("aaaabbbbcccc");
        System.out.println("res = " + res);
    }
}