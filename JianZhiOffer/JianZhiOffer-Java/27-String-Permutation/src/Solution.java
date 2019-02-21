import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    // 使用 TreeSet 进行去重排序
    private Set<String> permutations = new TreeSet<>();

    public ArrayList<String> Permutation(String str) {
        StringBuilder res = new StringBuilder(str);
        for (int i = 0; i < res.length(); i++) {
            permutation(res, 0, i);
        }
        return new ArrayList<>(permutations);
    }

    /**
     * 把字符串分为两部分，一部分是字符串的第一个字符，剩下的字符串为后一部分
     * 每次拿第一个字符与后部分字符串中的任一个字符进行交换，然后固定第一部分
     * 剩下部分任然分为两部分，重复以上操作
     *
     * @param res
     * @param beginIndex
     * @param replaceIndex
     */
    private void permutation(StringBuilder res, int beginIndex, int replaceIndex) {
        permutations.add(res.toString());
        for (int i = beginIndex + 1; i < res.length(); i++) {
            // 递归
            switchLetter(res, beginIndex, replaceIndex);
            permutation(res, beginIndex + 1, i);
            // 回溯
            switchLetter(res, beginIndex, replaceIndex);
        }
    }

    private void switchLetter(StringBuilder res, int indexA, int indexB) {
        char letterA = res.charAt(indexA);
        res.setCharAt(indexA, res.charAt(indexB));
        res.setCharAt(indexB, letterA);
    }
}