package NO_1078_Occurrences_After_Bigram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bigram 分词
 * https://leetcode-cn.com/problems/occurrences-after-bigram/
 */
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String flag = "*";
        text = text.replaceAll(first + " " + second, flag);
        String[] words = text.split(" ");

        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(flag) && i < words.length - 1) {
                if (words[i + 1].equals(flag))
                    res.add(first);
                else
                    res.add(words[i + 1]);
            }
        }
        return res.toArray(new String[0]);
    }

    public String[] findOcurrences2(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second))
                res.add(words[i + 2]);
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] res = s.findOcurrences("we will we will rock you", "we", "will");
        System.out.println(Arrays.toString(res));
    }
}
