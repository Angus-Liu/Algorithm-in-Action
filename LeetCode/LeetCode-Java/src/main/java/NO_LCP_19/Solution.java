package NO_LCP_19;

import java.util.ArrayList;
import java.util.List;

/**
 * 秋叶收藏集
 * https://leetcode-cn.com/problems/UlBDOe/
 */
class Solution {
    public int minimumOperations(String leaves) {
        List<Character> leafList = new ArrayList<>();
        for (char c : leaves.toCharArray()) {
            leafList.add(c);
        }
        if (leafList.stream().allMatch(leaf -> leaf == 'r')) return 1;
        if (leafList.stream().allMatch(leaf -> leaf == 'y')) return 2;
        int res = 0;
        int head = 0;
        for (int i = 0; i < leafList.size(); i++) {
            if (leafList.get(i) == 'r') {
                head++;
            } else {
                break;
            }
        }
        if(head == 0) res++;
        int tail = leafList.size() - 1;
        for (int i = leafList.size() - 1; i >= 0; i--) {
            if (leafList.get(i) == 'r') {
                tail--;
            } else {
                break;
            }
        }
        if (tail == leafList.size() - 1) res++;
        int r = 0;
        int y = 0;
        for (int i = head; i <= tail; i++) {
            if (leafList.get(i) == 'r') {
                r++;
            } else {
                y++;
            }
        }
        if(r < y - 1) {
            res += r;
        } else {
            res += y - 1;
        }
        return res;
    }

    // TODO: angus on 2020/10/29
    // "ryyryyyrryyyyyryyyrrryyyryryyyyryyrrryryyyryrryrrrryyyrrrrryryyrrrrryyyryyryrryryyryyyyryyrryrryryy"
    // 41
}
