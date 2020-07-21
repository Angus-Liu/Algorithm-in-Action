class Solution {
    public int hammingDistance(int x, int y) {
        int dist = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += dist & 1;
            dist >>>= 1;
        }
        return count;
    }
}