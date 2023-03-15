package NO_1615_Maximal_Network_Rank;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connect = new boolean[n][n];
        int[] ranks = new int[n];
        for (int[] r : roads) {
            connect[r[0]][r[1]] = connect[r[1]][r[0]] = true;
            ranks[r[0]]++;
            ranks[r[1]]++;
        }
        int maxRank = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                maxRank = Math.max(maxRank, ranks[i] + ranks[j] + (connect[i][j] ? -1 : 0));
            }
        }
        return maxRank;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}});
        System.out.println("res = " + res);
    }
}
