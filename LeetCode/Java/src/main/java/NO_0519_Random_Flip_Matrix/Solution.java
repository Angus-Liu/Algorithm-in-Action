package NO_0519_Random_Flip_Matrix;

import java.util.Random;

/**
 * 随机翻转矩阵
 * https://leetcode-cn.com/problems/random-flip-matrix/
 */
class Solution {
    private int n, tSize, fIdx;

    /* 水塘信息 */
    private int rSize;
    private int[][] reservoir;

    private Random rand = new Random();

    public Solution(int m, int n) {
        this.n = n;
        tSize = m * n;
        rSize = Math.min(tSize, 1000);
        fIdx = rSize - 1;
        reservoir = new int[rSize][2];
        reset();
    }

    public int[] flip() {
        int[] res = reservoir[fIdx];
        fIdx = (fIdx + 1) % rSize;
        return res;
    }

    /**
     * 水塘抽样（Reservoir sampling）
     * https://zh.wikipedia.org/wiki/%E6%B0%B4%E5%A1%98%E6%8A%BD%E6%A8%A3
     */
    public void reset() {
        if (fIdx < rSize - 1) return;
        for (int i = 0; i < tSize; i++) {
            if (i < rSize) {
                reservoir[i][0] = i / n;
                reservoir[i][1] = i % n;
            } else {
                int r = rand.nextInt(i + 1);
                if (r < rSize) {
                    reservoir[r][0] = i / n;
                    reservoir[r][1] = i % n;
                }
            }
        }
        // 洗牌，避免连续调用失去随机性
        if (rSize == tSize) shuffle();
    }

    private void shuffle() {
        for (int i = 0; i < rSize / 2; i++) {
            int j = rand.nextInt(rSize);
            int[] t = reservoir[0];
            reservoir[0] = reservoir[j];
            reservoir[j] = t;
        }
    }

    public static void main(String[] args) {
        int m = 5, n = 5;
        int[][] counts = new int[m][n];
        Solution solution = new Solution(m, n);
        int total = 400 * 25;
        for (int i = 0; i < total; i++) {
            int[] res = solution.flip();
            counts[res[0]][res[1]]++;
            solution.reset();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("[" + i + "," + j + "]: " + (counts[i][j]));
            }
        }
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */

// class Solution {
//    int n, total, i;
//    int res[] = new int[2];
//    public Solution(int m, int n) {
//        this.n = n;
//        this.total = m * n;
//    }
//
//    public int[] flip() {
//        res[0] = i / n;
//        res[1] = i % n;
//        i = (i + 1) % total;
//        return res;
//    }
//
//    public void reset() {}
// }