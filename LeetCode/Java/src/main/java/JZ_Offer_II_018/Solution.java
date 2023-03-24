package JZ_Offer_II_018;

class Solution {
    public boolean isPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; l < r; ) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if (!Character.isLetterOrDigit(lc)) {
                l++;
            } else if (!Character.isLetterOrDigit(rc)) {
                r--;
            } else if (Character.toLowerCase(lc) == Character.toLowerCase(rc)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("res = " + res);
    }
}
