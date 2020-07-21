import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        List<Integer> c = new ArrayList<>();
        generateCombination(n, k, 1, c);
        return res;
    }

    /**
     * 求解组合 C(n, k)，当前已经找到的组合存储在 c 中，需要从 start 中开始搜索新的元素
     *
     * @param n
     * @param k
     * @param start
     * @param c
     */
    private void generateCombination(int n, int k, int start, List<Integer> c) {
        if (c.size() == k) {
            res.add(new ArrayList<>(c));
            return;
        }
        // 从 start 开始，主要是因为组合不讲究顺序，所以类似 [1, 2, 3]、[1, 3, 2]、[2, 3, 1] 等是一种情况，因此限定 start
        // 这里对 i 的取值使用剪枝法，因为 c 中还有 k - c.size() 个空位，所以 i 的取值范围 [i, n] 中至少要有 k - c.size() 个元素
        // 因此 i 最多为 n - (k - c.size()) + 1
        for (int i = start; i <= n - (k - c.size()) + 1; i++) {
            c.add(i);
            generateCombination(n, k, i + 1, c);
            c.remove(c.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(3, 2));
    }
}