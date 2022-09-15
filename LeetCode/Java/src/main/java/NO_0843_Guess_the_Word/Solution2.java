package NO_0843_Guess_the_Word;

import java.util.Arrays;

class Solution2 {

    /**
     * 根据单词之间的匹配度得到匹配度矩阵，matchMatrix[i][j] 表示 wordlist[i] 与 wordlist[j] 的匹配度
     */
    private int[][] getMatchMatrix(String[] wordlist) {
        int n = wordlist.length;
        int[][] matchMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int match = 0;
                for (int k = 0; k < 6; k++) {
                    if (wordlist[i].charAt(k) == wordlist[j].charAt(k)) match++;
                }
                matchMatrix[i][j] = matchMatrix[j][i] = match;
            }
        }
        return matchMatrix;
    }

    /**
     * 根据可能的单词 possibleWords 和匹配度矩阵 matchMatrix 获取最优的待猜测单词在 wordList 中的索引
     */
    private int optGuessIdx(boolean[] possibleWords, int[][] matchMatrix) {
        int optGuessIdx = 0;
        int minMaxMatchSize = Integer.MAX_VALUE;
        for (int i = 0; i < possibleWords.length; i++) {
            if (possibleWords[i]) {
                // matchSizes 用于保存该单词 7 个匹配度列表的大小
                int[] matchSizes = new int[7];
                for (int j = 0; j < matchMatrix[i].length; j++) {
                    int match = matchMatrix[i][j];
                    if (match != -1) matchSizes[match]++;
                }
                // 得到该单词匹配度列表中最大列表的大小
                int maxMatchSize = 0;
                for (int s : matchSizes) {
                    if (s > maxMatchSize) maxMatchSize = s;
                }
                // 若该值比已选出来的更小，则索引为 i 的单词更适合作为待猜测单词
                if (maxMatchSize < minMaxMatchSize) {
                    optGuessIdx = i;
                    minMaxMatchSize = maxMatchSize;
                }
            }

        }
        return optGuessIdx;
    }

    /**
     * wordlist 中每个单词与其他单词，通过匹配度划分可以构成匹配度分别为 0-6 的 7 个匹配度列表。选
     * 一个单词，让其与 secret 匹配，得到匹配度 x，若 x 为 6 则表明找到；若 x 不为 6，则 secret
     * 在该单词的 x 匹配度列表中。此时，将该列表中单词作为新的 wordlist，重复上述过程。
     * 为了尽可能减少查询次数，查询时应取某个单词对应的 7 个匹配度列表中单词数量最大值，是每个单词对应
     * 匹配度列表最大值中，最小的那个作为查询起点。
     */
    public void findSecretWord(String[] wordlist, Master master) {
        int[][] matchMatrix = getMatchMatrix(wordlist);
        int n = wordlist.length;
        boolean[] possibleWords = new boolean[n];
        Arrays.fill(possibleWords, true);
        while (true) {
            // 选择适当的单词进行猜测
            int guessIdx = optGuessIdx(possibleWords, matchMatrix);
            String guessWord = wordlist[guessIdx];
            // 进行猜测
            int matchFactor = master.guess(guessWord);
            if (matchFactor == 6) return;
            // 未猜中时，根据返回的匹配度，留下符合的单词
            for (int i = 0; i < n; i++) {
                if (matchMatrix[guessIdx][i] != matchFactor) possibleWords[i] = false;
                // 将其他单词与该猜测的单词的匹配度置为 -1，等同于将该单词从后续匹配和计算中移除
                matchMatrix[i][guessIdx] = -1;
            }
        }
    }
}
