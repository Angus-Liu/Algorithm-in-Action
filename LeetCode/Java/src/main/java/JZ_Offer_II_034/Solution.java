package JZ_Offer_II_034;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(orders, words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(int[] orders, String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            if (orders[ch1 - 'a'] != orders[ch2 - 'a']) {
                return orders[ch1 - 'a'] < orders[ch2 - 'a'];
            }
        }
        return len1 <= len2;
    }
}
