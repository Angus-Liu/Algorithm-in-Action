import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        // TreeSet 基于红黑树，算法大多时间复杂度为 O(log (n))
        // HashSet 采用 hash 表来实现的，算法大多时间复杂度为 O(1)
//        Set<String> set = new TreeSet<>();
        Set<String> set = new HashSet<>();
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (String word: words) {
            char[] chars = word.toCharArray();
            StringBuilder code = new StringBuilder();
            for (char ch : chars) {
                code.append(codes[ch - 'a']);
            }
            set.add(code.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
        System.out.println(res);
    }
}