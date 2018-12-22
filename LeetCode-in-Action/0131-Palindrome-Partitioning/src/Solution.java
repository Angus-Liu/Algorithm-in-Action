import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        // 递归回溯法解决
        if (s == null || s.length() == 0) {
            return res;
        }
        partition(s, new ArrayList<>(), 0);
        return res;
    }

    private void partition(String s, List<String> palindromes, int l) {
        if (l == s.length()) {
            res.add(new ArrayList<>(palindromes));
            return;
        }
        for (int r = l; r < s.length(); r++) {
            // 判断 s 的 l 到 r 位之间是否为回文串，是则继续递归
            if (isPalindrome(s, l, r)) {
                // 递归
                palindromes.add(s.substring(l, r + 1));
                partition(s, palindromes, r + 1);
                // 回溯
                palindromes.remove(palindromes.size() - 1);
            }
        }
    }

    /**
     * 判断 s 中 [l, r] 部分是否是回文串
     */
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
    }
}