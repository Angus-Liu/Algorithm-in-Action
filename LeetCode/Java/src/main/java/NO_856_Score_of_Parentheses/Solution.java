package NO_856_Score_of_Parentheses;

class Solution {

    public int scoreOfParentheses(String s) {
        int n = s.length();
        int layer = 0;
        int[] scores = new int[n / 2 + 1];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                scores[++layer] = 0;
            } else {
                scores[layer - 1] += Math.max(2 * scores[layer], 1);
                layer--;
            }
        }
        return scores[layer];
    }

    public static void main(String[] args) {
        String s = "(()(())(()))";
        int res = new Solution().scoreOfParentheses(s);
        System.out.println(res);
    }
}
