package JZ_Offer_II_020;

class Solution {
    /**
     * 中心拓展
     */
    public int countSubstrings(String s) {
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            cnt += countPalindrome(chars, i, i);
            cnt += countPalindrome(chars, i, i + 1);
        }
        return cnt;
    }

    private int countPalindrome(char[] chars, int l, int r) {
        int cnt = 0;
        while (l >= 0 && r < chars.length && chars[l--] == chars[r++]) {
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.countSubstrings("aaa");
        System.out.println("res = " + res);
    }
}
