package NO_1638_Count_Substrings_That_Differ_by_One_Character;

class Solution {
    public int countSubstrings(String s, String t) {
        int count = 0;
        for (int subLen = 0; subLen <= s.length(); subLen++) {
            for (int i = 0; i < s.length() - subLen; i++) {
                for (int j = 0; j < t.length() - subLen; j++) {
                    if (diffByOne(s, i, t, j, subLen)) count++;
                }
            }
        }
        return count;
    }

    private boolean diffByOne(String s, int sl, String t, int tl, int len) {
        int diff = 0;
        for (int i = sl, j = tl; i <= sl + len; i++, j++) {
            if (s.charAt(i) != t.charAt(j)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.countSubstrings("abe", "bbc");
        System.out.println("res = " + res);
    }
}
