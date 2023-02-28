package NO_0557_Reverse_Words_in_a_String_III;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String reverseWords1(String s) {
        return Arrays.stream(s.split(" "))
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .collect(Collectors.joining(" "));
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = s.length(), l = 0, r = 0;
        while (l < n) {
            if (r == n || arr[r] == ' ') {
                reverse(arr, l, r - 1);
                l = r + 1;
            }
            r++;
        }
        return String.valueOf(arr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char tmp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.reverseWords(" Let's take LeetCode contest");
        System.out.println("res = " + res);
    }
}