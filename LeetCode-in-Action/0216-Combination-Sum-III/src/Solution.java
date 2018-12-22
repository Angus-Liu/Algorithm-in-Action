import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) {
            return res;
        }
        List<Integer> c = new ArrayList<>();
        generateCombination(k, n, 1, c, 0);
        return res;
    }

    private void generateCombination(int k, int n, int start, List<Integer> c, int cSum) {
        if (cSum > n || k < 0) {
            return;
        }
        if (cSum == n && k == 0) {
            res.add(new ArrayList<>(c));
            return;
        }
        // 这里对 i 的取值进行了剪枝，最大值由 9 改为 9 - k + 1，速率提升 30% 左右
        for (int i = start; i <= 9 - k + 1; i++) {
            // 递归
            c.add(i);
            generateCombination(k - 1, n, i + 1, c, cSum + i);
            // 回溯
            c.remove(c.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
        System.out.println(new Solution().combinationSum3(3, 9));
    }
}