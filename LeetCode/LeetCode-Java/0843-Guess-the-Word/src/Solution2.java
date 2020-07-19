import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author angus on 2020/7/11
 * @since 1.0.0
 */
class Solution2 {
    /**
     * 每个单词与其他单词的相似度可以构成相似度分别为 0-6 的 7 个相似度列表，此时选一个单词，
     * 让其与 secret 匹配，得到相似度 x，若 x 为 6 则表明找到；若 x 不为 6，则 secret 在
     * 该单词的 x 相似度列表中。将改列表中单词作为新的 wordlist，递归上述过程。为了尽可能减
     * 少查询次数，我们取相似度列表中单词数量最大值是所有单词的相似度列表单词数最大值中最小的
     * 单词作为查询起点。未优化，效率不高。
     */
    public void findSecretWord(String[] wordlist, Master master) {
        Map<String, Map<Integer, List<String>>> wordMatchMap = new HashMap<>();
        for (String w1 : wordlist) {
            for (String w2 : wordlist) {
                // 获取两个单词的匹配度
                Integer matchFactor = calMatchFactor(w1, w2);
                // 将 w2 放入 w1 指定匹配度单词列表中
                Map<Integer, List<String>> matchFactorWordMap = wordMatchMap.getOrDefault(w1, new HashMap<>());
                List<String> wordList = matchFactorWordMap.getOrDefault(matchFactor, new ArrayList<>());
                wordList.add(w2);
                matchFactorWordMap.put(matchFactor, wordList);
                wordMatchMap.put(w1, matchFactorWordMap);
            }
        }
        // 选出匹配度单词列表数量最大值在所有单词中最小的那个单词
        String guessWord = "";
        int miniMaxSize = wordlist.length;
        for (Map.Entry<String, Map<Integer, List<String>>> entry : wordMatchMap.entrySet()) {
            String word = entry.getKey();
            Map<Integer, List<String>> matchFactorWordMap = entry.getValue();
            int maxSize = 0;
            for (List<String> wordList : matchFactorWordMap.values()) {
                if (wordList.size() > maxSize) maxSize = wordList.size();
            }
            if (maxSize <= miniMaxSize) {
                guessWord = word;
                miniMaxSize = maxSize;
            }
        }
        // 与 secret 进行匹配
        int matchFactor = master.guess(guessWord);
        if (matchFactor == 6) return;
        // 未猜中时，将该匹配度对应的单词列表作为下次的 wordlist
        List<String> nextWordList = wordMatchMap.get(guessWord).get(matchFactor);
        findSecretWord(nextWordList.toArray(new String[0]), master);
    }

    /**
     * 计算两个单词的匹配因子
     */
    private int calMatchFactor(String w1, String w2) {
        int matchFactor = 0;
        for (int i = 0; i < 6; i++) {
            if (w1.charAt(i) == w2.charAt(i)) matchFactor++;
        }
        return matchFactor;
    }
}