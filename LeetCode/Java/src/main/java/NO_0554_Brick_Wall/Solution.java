package NO_0554_Brick_Wall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /**
     * 统计每列缝隙出现的次数。找出缝隙最多的那一列，相应的改列砖块就最少。
     */
    public int leastBricks(List<List<Integer>> wall) {
        // key - 列号，value - 该列中缝隙出现的次数
        Map<Integer, Integer> gapCnt = new HashMap<>();
        wall.forEach(row -> {
            for (int i = 0, col = 0; i < row.size() - 1; i++) {
                col += row.get(i);
                gapCnt.merge(col, 1, Integer::sum);
            }
        });
        // 砖的行数减去所有列中缝隙出现次数最多的一列的缝隙数，即使穿过的砖块数量最少
        return wall.size() - gapCnt.values().stream().max(Integer::compareTo).orElse(0);
    }
}
