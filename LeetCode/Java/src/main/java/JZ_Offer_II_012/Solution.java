package JZ_Offer_II_012;

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];
        for (int i = n - 1, rs = 0; i >= 0; i--) {
            sums[i] = rs;
            rs += nums[i];
        }
        for (int i = 0, ls = 0; i < n; i++) {
            if (sums[i] - ls == 0) return i;
            ls += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.pivotIndex(new int[]{2, 5, 2, 3, -3, 5, 4, 3});
        System.out.println(res);
        res = solution.pivotIndex(new int[]{2, 1, -1});
        System.out.println(res);
    }
}
