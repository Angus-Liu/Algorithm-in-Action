package NO_0843_Guess_the_Word;

import java.util.*;

class Solution {

    private final int MAX_MATCH_FAC = 6;

    /**
     * 计算两个单词的匹配度
     */
    private int calMatchFactor(String w1, String w2) {
        int matchFactor = 0;
        for (int i = 0; i < MAX_MATCH_FAC; i++) {
            if (w1.charAt(i) == w2.charAt(i)) matchFactor++;
        }
        return matchFactor;
    }

    /**
     * 获取单词匹配度映射，key 为单词，value 为与该单词匹配度
     */
    private Map<String, Map<Integer, Set<String>>> initWordMatchFacMap(String[] wordlist) {
        Map<String, Map<Integer, Set<String>>> wordMatchMap = new HashMap<>();
        for (String w1 : wordlist) {
            for (String w2 : wordlist) {
                // 获取两个单词的匹配度
                Integer matchFactor = calMatchFactor(w1, w2);
                // 将 w2 放入 w1 指定匹配度单词列表中
                Map<Integer, Set<String>> matchFactorWordMap = wordMatchMap.getOrDefault(w1, new HashMap<>());
                Set<String> wordList = matchFactorWordMap.getOrDefault(matchFactor, new HashSet<>());
                wordList.add(w2);
                matchFactorWordMap.put(matchFactor, wordList);
                wordMatchMap.put(w1, matchFactorWordMap);
            }
        }
        return wordMatchMap;
    }

    private void removeWord(Map<String, Map<Integer, Set<String>>> wordMatchMap, String guessWord, int matchFactor) {
        Set<String> nextWordList = wordMatchMap.get(guessWord).get(matchFactor);
        wordMatchMap.entrySet().removeIf(entry -> !nextWordList.contains(entry.getKey()));
        for (Map.Entry<String, Map<Integer, Set<String>>> entry : wordMatchMap.entrySet()) {
            for (Map.Entry<Integer, Set<String>> integerListEntry : entry.getValue().entrySet()) {
                integerListEntry.getValue().remove(guessWord);
            }
        }
    }

    private String guessWord(Map<String, Map<Integer, Set<String>>> wordMatchMap) {
        String guessWord = "";
        int miniMaxSize = Integer.MAX_VALUE;
        for (Map.Entry<String, Map<Integer, Set<String>>> entry : wordMatchMap.entrySet()) {
            String word = entry.getKey();
            Map<Integer, Set<String>> matchFactorWordMap = entry.getValue();
            int maxSize = 0;
            for (Set<String> words : matchFactorWordMap.values()) {
                if (words.size() > maxSize) maxSize = words.size();
            }
            if (maxSize <= miniMaxSize) {
                guessWord = word;
                miniMaxSize = maxSize;
            }
        }
        return guessWord;
    }

    /**
     * wordlist 中每个单词与其他单词，通过匹配度划分可以构成匹配度分别为 0-6 的 7 个匹配度列表。选一个
     * 单词，让其与 secret 匹配，得到匹配度 x，若 x 为 6 则表明找到；若 x 不为 6，则 secret 在该
     * 单词的 x 匹配度列表中。此时，将该列表中单词作为新的 wordlist，重复上述过程。
     * 为了尽可能减少查询次数，查询时应取某个单词对应 7 个匹配度列表中单词数量最大值，是所有单词对应的
     * 匹配度列表最大值中最小的那个作为查询起点。
     */

    public void findSecretWord(String[] wordlist, Master master) {
        Map<String, Map<Integer, Set<String>>> wordMatchMap = initWordMatchFacMap(wordlist);
        while (true) {
            // 选出匹配度单词列表数量最大值在所有单词中最小的那个单词
            String guessWord = guessWord(wordMatchMap);
            // 与 secret 进行匹配
            int matchFactor = master.guess(guessWord);
            if (matchFactor == MAX_MATCH_FAC) return;
            // 未猜中时，将该匹配度对应的单词列表作为下次的 wordlist
            removeWord(wordMatchMap, guessWord, matchFactor);
        }
    }
}
