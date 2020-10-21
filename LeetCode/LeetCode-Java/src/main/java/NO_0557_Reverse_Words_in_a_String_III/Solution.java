package NO_0557_Reverse_Words_in_a_String_III;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(new StringBuilder(word).reverse());
            res.append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}