package JZ_Offer_II_067;

class Solution {
    /**
     * BF 解法超时
     */
    public int findMaximumXOR1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    static class Node {
        private final Node[] children = new Node[2];
    }

    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        // build tree
        for (int num : nums) {
            Node cur = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (cur.children[bit] == null) {
                    cur.children[bit] = new Node();
                }
                cur = cur.children[bit];
            }
        }
        // find max
        int max = 0;
        for (int num : nums) {
            Node cur = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (cur.children[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    cur = cur.children[1 - bit];
                } else {
                    xor <<= 1;
                    cur = cur.children[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }
}
