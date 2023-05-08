package JZ_Offer_II_064;

class MagicDictionary2 {
    private boolean isWord;
    private final MagicDictionary2[] children;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary2() {
        isWord = false;
        children = new MagicDictionary2[26];
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            MagicDictionary2 cur = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new MagicDictionary2();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(this, searchWord, 0, false);
    }

    private boolean dfs(MagicDictionary2 node, String word, int i, boolean hasDiff) {
        if (i == word.length()) {
            return node.isWord && hasDiff;
        }
        int index = word.charAt(i) - 'a';
        if (node.children[index] != null && dfs(node.children[index], word, i + 1, hasDiff)) {
            return true;
        }
        if (!hasDiff) {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null && j != index && dfs(node.children[j], word, i + 1, true)) {
                    return true;
                }
            }
        }
        return false;
    }
}
