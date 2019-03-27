class Solution {
    public boolean isMatch(String s, String p) {
        return match(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean match(char[] str, int s, char[] pattern, int p) {
        // 模式串匹配到末尾时，判断待匹配串是否匹配完毕
        if (p == pattern.length) {
            return s == str.length;
        }
        // 若模式串的第二个字符为'*'，可先略过，比较之后的字符串
        // 考虑诸如 str=[]，pattern = [.*] 或 str=[bc]，pattern = [a*bc] 等情况
        if (p + 1 < pattern.length
                && pattern[p + 1] == '*'
                && match(str, s, pattern, p + 2)) {
            return true;
        }
        if (s < str.length && (str[s] == pattern[p] || pattern[p] == '.')) {
            // 考虑诸如 str=[abc]，pattern = [.bc] 情况
            if (match(str, s + 1, pattern, p + 1)) {
                return true;
            }
            // 考虑诸如 str=[abc]，pattern = [.*] 或 str=[aaa]，pattern = [a*] 等情况
            if (p + 1 < pattern.length
                    && pattern[p + 1] == '*'
                    && match(str, s + 1, pattern, p)) {
                return true;
            }
        }
        return false;
    }
}