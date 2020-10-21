package NO_0191_Number_of_1_Bits;

public class Solution {
    public int hammingWeight_1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight(int n) {
        String binStr = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binStr.length(); i++) {
            if (binStr.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(1));
        System.out.println(new Solution().hammingWeight(Integer.MAX_VALUE));
        System.out.println(new Solution().hammingWeight(-1));
        System.out.println(new Solution().hammingWeight(Integer.MIN_VALUE));
    }
}