package JZ_Offer_II_005;

public class Solution {

    public int maxProduct1(String[] words) {
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i][c - 'a'] = true;
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                boolean hasSameChar = false;
                for (int k = 0; k < 26; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        hasSameChar = true;
                        break;
                    }
                }
                if (!hasSameChar) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }

    public int maxProduct(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                // flags[i] 保存 words[i] 对应的字母信息，
                // 其对应的二进制的最右边第 1 位表示该单词是否含有字母 a，第 2 位表示是否含有字母 b，以此类推
                flags[i] |= 1 << (ch - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // words[i] 与 words[j] 不含有相同字母时，对应 flags[i] 与 flags[j] 相与为 0
                if ((flags[i] & flags[j]) == 0)
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"abcw", "baz", "foo", "bar", "fxyz", "abcdef"};
        int maxProduct = solution.maxProduct(words);
        System.out.println("maxProduct = " + maxProduct);
    }
}
