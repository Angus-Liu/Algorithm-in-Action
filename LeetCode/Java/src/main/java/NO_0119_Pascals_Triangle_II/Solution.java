package NO_0119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j < res.size() - 1; j++) {
                // 每一行由上一行得到
                res.set(j, res.get(j) + res.get(j + 1));
            }
            // 记得第一个元素是个特例
            res.add(0, 1);
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().getRow(3);
    }
}