package JZ_Offer_II_065;

class Solution {

    private Trie root = new Trie();

    static class Trie {
        Trie[] children;

        public Trie() {
            this.children = new Trie[26];
        }
    }

    public int minimumLengthEncoding(String[] words) {
        for (String word : words) {
            Trie node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
        }
        return dfs(root, 0);
    }

    private int dfs(Trie root, int curPathLen) {
        boolean isLeaf = true;
        int childrenPathsLen = 0;
        for (Trie child : root.children) {
            if (child != null) {
                isLeaf = false;
                childrenPathsLen += dfs(child, curPathLen + 1);
            }
        }
        return isLeaf ? curPathLen + 1: childrenPathsLen;
    }

    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        Solution solution = new Solution();
        int len = solution.minimumLengthEncoding(words);
        System.out.println("len = " + len);
    }
}
