package NO_0680_Valid_Palindrome_II;

class Solution {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                // 无法确认那个字符是多余的，所有左右都需验证一下
                return validPalindrome(chars, i, j - 1) || validPalindrome(chars, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean validPalindrome(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("aba"));
        System.out.println(new Solution().validPalindrome("abc"));
        System.out.println(new Solution().validPalindrome("ececabbacec"));
    }
}