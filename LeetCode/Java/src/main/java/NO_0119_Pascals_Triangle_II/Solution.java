package NO_0119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j < res.size() - 1; j++) {
                // 每一行由上一行得到
                res.set(j, res.get(j) + res.get(j + 1));
            }
            // 记得第一个元素是个特例
            res.add(0, 1);
        }
        return res;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < rowIndex; i++) {
            res.add(1); // 尾部为 1
            for (int j = i; j > 0; j--) {
                // 每一行由上一行得到
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> row = new Solution().getRow(3);
        System.out.println("row = " + row);
    }
}