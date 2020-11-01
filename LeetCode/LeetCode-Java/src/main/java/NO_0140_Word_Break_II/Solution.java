package NO_0140_Word_Break_II;

import java.util.*;

/**
 * 单词拆分 II
 * https://leetcode-cn.com/problems/word-break-ii/
 * 如果你会做 139. 单词拆分，那么这道题就可以直接照搬思路（😯效率不高，下次再优化吧）
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // key - 当前字母的在 s 中的索引
        // value - 其中每个索引均满足与当前字母索引之间的单词在 wordDict 中
        Map<Integer, Set<Integer>> breakIndexMap = new HashMap<>();
        breakIndexMap.put(0, new HashSet<>());
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (breakIndexMap.containsKey(j) && wordDict.contains(s.substring(j, i))) {
                    Set<Integer> breakIndex = breakIndexMap.getOrDefault(i, new HashSet<>());
                    breakIndex.add(j);
                    breakIndexMap.put(i, breakIndex);
                }
            }
        }
        return genSentence(s, breakIndexMap, n);
    }

    private List<String> genSentence(String s, Map<Integer, Set<Integer>> breakIndexMap, int endIndex) {
        List<String> sentenceList = new ArrayList<>();
        if (endIndex == 0) return sentenceList;
        Set<Integer> beginIndexSet = breakIndexMap.get(endIndex);
        if (beginIndexSet == null || beginIndexSet.isEmpty())
            return sentenceList;
        for (int beginIndex : beginIndexSet) {
            String word = s.substring(beginIndex, endIndex);
            List<String> subSentenceList = genSentence(s, breakIndexMap, beginIndex);
            if (subSentenceList.isEmpty()) {
                sentenceList.add(word);
            } else {
                for (String s1 : subSentenceList) {
                    sentenceList.add(s1 + " " + word);
                }
            }
        }
        return sentenceList;
    }
}