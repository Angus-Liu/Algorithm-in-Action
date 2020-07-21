import java.util.Arrays;
import java.util.List;

class Solution {

    public String reverseVowels_1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        // 对撞指针实现
        char[] chars = s.toCharArray();
        for (int l = 0, r = s.length() - 1; l < r;) {
            if (vowelList.contains(chars[l])) {
                if (vowelList.contains(chars[r])) {
                    char temp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = temp;
                    l++;
                    r--;
                } else {
                    r--;
                }
            } else {
                l++;
            }
        }
        return String.valueOf(chars);
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // 对撞指针实现
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            char lch = chars[l];
            char rch = chars[r];
            if (isVowel(lch)) {
                if (isVowel(rch)) {
                    char temp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = temp;
                    l++;
                    r--;
                } else {
                    r--;
                }
            } else {
                l++;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("hello"));
        System.out.println(solution.reverseVowels("leetcode"));
    }
}