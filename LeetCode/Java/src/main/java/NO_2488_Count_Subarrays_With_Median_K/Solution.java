package NO_2488_Count_Subarrays_With_Median_K;

import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * 暴力（超时）
     */
    public int countSubarrays1(int[] nums, int k) {
        int kIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.compare(nums[i], k);
            if (nums[i] == 0) kIdx = i;
        }
        int res = 0;
        for (int i = 0; i <= kIdx; i++) {
            for (int j = i, sum = 0; j < nums.length; j++) {
                sum += nums[j];
                if ((kIdx <= j) && (sum == 0 || sum == 1)) res++;
            }
        }
        return res;
    }

    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int kIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                kIdx = i;
                break;
            }
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum += sign(nums[i] - k);
            if (i < kIdx) {
                cnt.merge(sum, 1, Integer::sum);
            } else {
                int prev0 = cnt.getOrDefault(sum, 0);
                int prev1 = cnt.getOrDefault(sum - 1, 0);
                ans += prev0 + prev1;
            }
        }
        return ans;
    }

    public int sign(int num) {
        if (num == 0) {
            return 0;
        }
        return num > 0 ? 1 : -1;
    }
}