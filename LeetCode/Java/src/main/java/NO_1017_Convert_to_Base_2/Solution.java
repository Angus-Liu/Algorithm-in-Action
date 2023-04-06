package NO_1017_Convert_to_Base_2;

class Solution {
    public String baseNeg2(int n) {
        // TODO
        return Integer.toBinaryString(n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        for (int i = 0; i < 1; i++) {
            solution.baseNeg2(i);
        }
    }
}