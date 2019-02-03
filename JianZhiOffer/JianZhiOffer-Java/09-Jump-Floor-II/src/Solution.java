public class Solution {
    public int JumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        int res = 0, one = 1, two = 2;
        for (int i = 3; i <= target; i++) {
            res = one + one + two;
            one = two;
            two = res;
        }
        return res;
    }
}