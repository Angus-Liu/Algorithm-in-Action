package JZ_Offer_II_065;

class Solution {
    static class Trie {
        private boolean isLeaf = false;
        private final Trie[] next = new Trie[26];
    }

    public int minimumLengthEncoding(String[] words) {
        int minLen = 0;
        Trie root = new Trie();
        for (String word : words) {
            Trie cur = root;
            boolean hasNewBranch = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                if (cur.next[idx] == null) {
                    cur.next[idx] = new Trie();
                    hasNewBranch = true;
                    if (cur.isLeaf) {
                        cur.isLeaf = false;
                        minLen -= word.length() - i;
                    }
                }
                cur = cur.next[idx];
            }
            if (hasNewBranch) {
                cur.isLeaf = true;
                minLen += word.length() + 1;
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        String[] words = {"time", "ime", "bell"};
        Solution solution = new Solution();
        int len = solution.minimumLengthEncoding(words);
        System.out.println("len = " + len);
    }
}
