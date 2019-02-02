public class Solution {
    /**
     * 斐波拉切数列的应用
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int res = 0, one = 1, two = 2;
        for (int i = 3; i <= target; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }
}