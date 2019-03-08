import java.util.Arrays;

public class Solution {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) return str;
        String[] words = str.split(" ");
        if (words.length <= 1) return str;
        int start = 0, end = words.length - 1;
        while (start < end) {
            String temp = words[start];
            words[start++] = words[end];
            words[end--] = temp;
        }
        return Arrays.stream(words)
                .reduce((str1, str2) -> str1 + " " + str2)
                .get();
    }

    public static void main(String[] args) {
        String res = new Solution().ReverseSentence(" ");
        System.out.println("res = " + res);
    }
}