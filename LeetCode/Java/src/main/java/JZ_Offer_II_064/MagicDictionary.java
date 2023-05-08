package JZ_Offer_II_064;

import java.util.HashMap;
import java.util.Map;

class MagicDictionary {

    private boolean isWord;
    private final Map<Character, MagicDictionary> children;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        isWord = false;
        children = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            MagicDictionary cur = this;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new MagicDictionary());
                cur = cur.children.get(c);
            }
            cur.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(this, searchWord, 0, 0);
    }

    private boolean dfs(MagicDictionary node, String word, int i, int diff) {
        if (i > word.length() || diff > 1) return false;
        if (i == word.length()) return node.isWord && diff == 1;
        for (Map.Entry<Character, MagicDictionary> next : node.children.entrySet()) {
            if (dfs(next.getValue(), word, i + 1, next.getKey() == word.charAt(i) ? diff : diff + 1)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */