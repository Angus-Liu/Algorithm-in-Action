class Solution {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        int[] freq = new int[256];
        for (char ch : chars) {
            freq[ch]++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = chars.length; i > 0; i--) {
            for (int j = 0; j < freq.length; j++) {
                if (freq[j] == i) {
                    for (int k = 0; k < i; k++) {
                        res.append((char) j);
                    }
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree"));
        System.out.println(solution.frequencySort("cccaaa"));
        System.out.println(solution.frequencySort("Aabb"));
        System.out.println(solution.frequencySort("eeeee"));
    }
}