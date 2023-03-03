package NO_0030_Substring_with_Concatenation_of_All_Words;

import java.util.*;

public class Solution {

    private Map<String, Integer> genWordMap(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.merge(word, 1, Integer::sum);
        }
        return wordMap;
    }

    /**
     * 该方法较后面的方法更为高效
     */
    public List<Integer> findSubstring1(String s, String[] words) {
        int sLen = s.length();
        int wLen = words[0].length(), wCnt = words.length, wsLen = wLen * wCnt;
        List<Integer> res = new ArrayList<>();
        if (sLen < wsLen) return res;

        Map<String, Integer> wordMap = genWordMap(words);

        Map<String, Integer> subStrMap = new HashMap<>();
        // O(wLen * sLen / wLen) = O(sLen)
        for (int i = 0; i < wLen; i++) {
            for (int j = wLen + i, c = 1; j <= sLen; j += wLen, c++) {
                String subStr = s.substring(j - wLen, j);
                subStrMap.merge(subStr, 1, Integer::sum);
                if (c >= wCnt) {
                    if (wordMap.equals(subStrMap)) {
                        res.add(j - wsLen);
                    }
                    subStrMap.merge(
                            s.substring(j - wsLen, j - wsLen + wLen),
                            -1,
                            (oldValue, newValue) -> oldValue + newValue == 0 ? null : oldValue + newValue
                    );
                }
            }
            subStrMap.clear();
        }
        return res;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int sLen = s.length();
        int wLen = words[0].length(), wCnt = words.length, wsLen = wLen * wCnt;
        List<Integer> res = new ArrayList<>();
        if (sLen < wsLen) return res;

        Map<String, Integer> wordMap = genWordMap(words);

        Map<String, Integer> subStrMap = new HashMap<>();
        // O((sLen - wsLen) * wCnt)
        for (int i = 0; i <= sLen - wsLen; i++) {
            for (int j = i; j < i + wsLen; j += wLen) {
                String subStr = s.substring(j, j + wLen);
                subStrMap.merge(subStr, 1, Integer::sum);
            }
            if (wordMap.equals(subStrMap)) {
                res.add(i);
            }
            subStrMap.clear();
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"});
        System.out.println("res = " + res);
        res = solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        System.out.println("res = " + res);
    }
}