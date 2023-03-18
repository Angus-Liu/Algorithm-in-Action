package NO_1616_Split_Two_Strings_to_Make_Palindrome;

import java.util.Map;

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        if (isPalindrome(a) || isPalindrome(b)) return true;
        int n = a.length();
        for (int i = 1; i < n; i++) {
            String aPref = a.substring(0, i);
            String aSuff = a.substring(i, n);
            String bPref = b.substring(0, i);
            String bSuff = b.substring(i, n);
            if (isPalindrome(aPref + bSuff) || isPalindrome(bPref + aSuff)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Map.of(
                "x", "y",
                "abdef", "fecab",
                "ulacfd", "jizalu"
        ).forEach((a, b) -> {
            boolean res = solution.checkPalindromeFormation(a, b);
            System.out.printf("a: %s, b: %s, res = %s\n", a, b, res);
        });
    }
}
