public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuilder res = new StringBuilder();
        for (char c : str.toString().toCharArray()) {
            if (' ' == c) {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}