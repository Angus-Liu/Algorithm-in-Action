import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 图论方式求解，以图来建模
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);
        int begin = wordList.indexOf(beginWord);
        int n = wordList.size();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                g[i][j] = g[j][i] = similar(wordList.get(i), wordList.get(j));
            }
        }
        // BFS
        LinkedList<Integer> q = new LinkedList<>();
        int[] step = new int[n];

        q.addLast(begin);
        step[begin] = 1;
        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            for (int i = 0; i < n; i++) {
                if (step[i] == 0 && g[cur][i]) {
                    if (i == end) {
                        return step[cur] + 1;
                    }
                    step[i] = step[cur] + 1;
                    q.addLast(i);
                }
            }
        }

        return 0;
    }

    private boolean similar(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(solution.ladderLength("hit", "cog", wordList));
    }
}