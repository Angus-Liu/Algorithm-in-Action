package NO_1630_Arithmetic_Subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            res.add(isArithmeticSubarray(nums, l[i], r[i]));
        }
        return res;
    }

    private boolean isArithmeticSubarray(int[] nums, int l, int r) {
        if (r == l) return true;
        int[] sub = Arrays.copyOfRange(nums, l, r + 1);
        Arrays.sort(sub);
        int diff = sub[1] - sub[0];
        for (int i = 2; i < sub.length; i++) {
            if (sub[i] - sub[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
