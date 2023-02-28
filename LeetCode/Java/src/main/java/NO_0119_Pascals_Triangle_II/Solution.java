package NO_0119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    /**
     * 由前一行正向递推
     */
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

    /**
     * 由前一行反向递推
     */
    public List<Integer> getRow2(int rowIndex) {
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

    /**
     * 排列组合数思想，例 rowIndex = 3
     * C{_3 _0} = C{_3 ^3} = 1 / 1 = 1
     * C{_3 ^1} = C{_3 ^2} = 1 * 3 / 1 * 1 = 3
     * Row = [1, 3, 3, 1]
     */
    public List<Integer> getRow3(int rowIndex) {
        List<Integer> res = new ArrayList<>(Collections.nCopies(rowIndex + 1, 0));
        long deno = 1, nume = 1;
        for (int i = 0; i <= rowIndex / 2; i++) {
            int comNum = (int) (deno / nume); // 组合数
            res.set(i, comNum);
            res.set(rowIndex - i, comNum);
            deno *= rowIndex - i; // 即使 deno 为 long，这里还是会溢出
            nume *= i + 1;
        }
        return res;
    }

    /**
     * 对上个方法的优化，减少重复计算，避免了溢出问题
     */
    public List<Integer> getRow4(int rowIndex) {
        List<Integer> res = new ArrayList<>(Collections.nCopies(rowIndex + 1, 0));
        int comNum = 1;
        for (int i = 0; i <= rowIndex / 2; i++) {
            res.set(i, comNum);
            res.set(rowIndex - i, comNum);
            // 减少重复计算，避免溢出
            comNum = (int) (((long) comNum * (rowIndex - i)) / (i + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> row = new Solution().getRow4(3);
        System.out.println("row = " + row);
    }
}
