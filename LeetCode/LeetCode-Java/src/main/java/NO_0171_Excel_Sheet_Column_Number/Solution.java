package NO_0171_Excel_Sheet_Column_Number;

class Solution {
    public int titleToNumber(String s) {
        if (s == null) return 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            res = res * 26 + (c - 'A') + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"A", "B", "C", "Z", "AA", "AB", "ZY"};
        for (String s : strs) {
            System.out.println(solution.titleToNumber(s));
        }
    }
}