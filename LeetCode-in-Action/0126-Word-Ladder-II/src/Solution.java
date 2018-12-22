import java.util.*;

class Solution {

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 利用图论求解，保存每条路径
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return res;
        }
        wordList.add(beginWord);
        int begin = wordList.indexOf(beginWord);
        int n = wordList.size();
        // 比较单词间两两相似性，初始化 g
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                g[i][j] = g[j][i] = similar(wordList.get(i), wordList.get(j));
            }
        }
        // BFS
        boolean[] visited = new boolean[n];
        visited[begin] = true;
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        LinkedList<String> q = new LinkedList<>();
        q.addLast(beginWord);
        bfs(wordList, list, q, visited, g, begin, end);
        return res;
    }

    private void bfs(List<String> wordList, List<String> list, LinkedList<String> q, boolean[] visited, boolean[][] g, int begin, int end) {
        if (q.isEmpty()) {
            return;
        }
        // 递归回溯
        for (int i = 0; i < wordList.size(); i++) {
            if (!visited[i] && g[begin][i]) {
                visited[i] = true;
                list.add(wordList.get(i));
                if (i == end) {
                    res.add(new ArrayList<>(list));
                }
                bfs(wordList, list, q, visited, g, i, end);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    private void getRes(List<List<Integer>> g, int cur, int end, Map<Integer, Integer> distance,
                        List<String> wordList, List<Integer> tres, List<List<String>> res) {

    }

    private List<String> getPath(List<Integer> path, List<String> wordList) {
        List<String> ret = new ArrayList<>();
        path.forEach(index -> {
            ret.add(wordList.get(index));
        });
        return ret;
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
        System.out.println(solution.findLadders("hit", "cog", wordList));
    }
}