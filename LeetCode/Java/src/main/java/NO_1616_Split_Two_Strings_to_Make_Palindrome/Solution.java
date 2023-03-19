package NO_1616_Split_Two_Strings_to_Make_Palindrome;

import java.util.Map;

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return checkSymmetry(a, b) || checkSymmetry(b, a);
    }

    private boolean checkSymmetry(String a, String b) {
        int l = 0, r = a.length() - 1;
        while (l < r && a.charAt(l) == b.charAt(r)) {
            l++;
            r--;
        }
        if (l >= r) return true;
        return isPalindrome(a, l, r) || isPalindrome(b, l, r);
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Map.of(
                "x", "y",
                "abdef", "fecab",
                "ulacfd", "jizalu",
                "acc", "der"
        ).forEach((a, b) -> {
            boolean res = solution.checkPalindromeFormation(a, b);
            System.out.printf("a: %s, b: %s, res = %s\n", a, b, res);
        });
    }
}
