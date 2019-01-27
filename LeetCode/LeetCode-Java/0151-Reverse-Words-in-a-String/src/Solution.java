public class Solution {
    public String reverseWords(String s) {
        // 表示一个或多个空格的正则表达式
        String[] words = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]);
            if (i != 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}