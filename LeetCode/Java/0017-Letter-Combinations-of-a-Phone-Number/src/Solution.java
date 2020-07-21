import java.util.ArrayList;
import java.util.List;

class Solution {

    private final String[] LETTER_MAP = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        // 树形问题
        findCombination(digits, 0, "");
        return res;
    }

    /**
     * 寻找和 digits[index] 匹配的字母，获得digits[0...index] 翻译得到的解
     *
     * @param digits 原数字串
     * @param index  digits 中待翻译的数字的索引
     * @param s      s 中保存了此时从 digits[0...index-1] 翻译得到一个字母字符串
     */
    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        // 获取待翻译数字及其对应字母串
        char c = digits.charAt(index);
        String letters = LETTER_MAP[c - '0'];
        for (char letter : letters.toCharArray()) {
            findCombination(digits, index + 1, s + letter);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("222"));
    }
}