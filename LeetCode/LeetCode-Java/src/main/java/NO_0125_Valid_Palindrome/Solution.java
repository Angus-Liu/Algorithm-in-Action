package NO_0125_Valid_Palindrome;

class Solution {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        // 对撞指针解法
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char lch = s.charAt(l);
            char rch = s.charAt(r);
            if ('0' <= lch && lch <= '9' || 'a' <= lch && lch <= 'z') {
                if ('0' <= rch && rch <= '9' || 'a' <= rch && rch <= 'z') {
                    if (lch == rch) {
                        l++;
                        r--;
                    } else {
                        return false;
                    }
                } else {
                    r--;
                }
            } else {
                l++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
        palindrome = solution.isPalindrome("0P");
        System.out.println(palindrome);
    }
}