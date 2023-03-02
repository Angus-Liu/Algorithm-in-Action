package JZ_Offer_II_003;

public class Solution {

    public int[] countBits1(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j != 0) {
                res[i] += 1;
                // 将数字二进制形式中最右边的 1 变成 0
                // 例：j = 1010, j-1 = 1001, j&(j-1) = 1000
                //    j = 1000, j-1 = 0111, j&(j-1) = 0000
                // 由上可以得出 j 比 j&(j-1) 的二进制形式中 1 的个数多 1
                j = j & (j - 1);
            }
        }
        return res;
    }

    public int[] countBits3(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 由上可以得出 j 比 j&(j-1) 的二进制形式中 1 的个数多 1
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 如果 i 是偶数，i 相当于将 i/2 左移一位，故 i 与 i/2 的二进制形式中 1 的个数相同
            // 如果 i 是奇数，i 相当于 i/2 左移一位之后，再将最右边一位设为 1，故二进制中 1 的个数比 i/2 多 1
            // i>>1 比 i/2 高效；i&1 比 i%1 高效
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.countBits(10);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d - %s - %d%n", i, Integer.toBinaryString(i), res[i]);
        }
    }
}
