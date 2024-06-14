#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    long long maxScore(vector<int> &nums, int x) {
        long long even = 0, odd = 0;
        if (nums[0] % 2 == 0) {
            even = nums[0];
            odd = even - x;
        } else {
            odd = nums[0];
            even = odd - x;
        }
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] % 2 == 0) {
                even = max(even + nums[i], odd + nums[i] - x);
            } else {
                odd = max(odd + nums[i], even + nums[i] - x);
            }
        }
        return max(odd, even);
    }

    long long maxScore2(vector<int> &nums, int x) {
        long long dp[2];
        int p = nums[0] & 1;
        dp[p] = nums[0];
        dp[1 - p] = nums[0] - x;
        for (int i = 1; i < nums.size(); i++) {
            p = nums[i] & 1;
            dp[p] = max(dp[p] + nums[i], dp[1 - p] + nums[i] - x);
        }
        return max(dp[0], dp[1]);
    }
};

int main(int argc, char *argv[]) {
    Solution solution;
    // 0 2 4 5
    // 2 x 6 x 9 2
    vector<int> nums = {8, 50, 65, 85, 8, 73, 55, 50, 29, 95, 5, 68, 52, 79};
    int x = 74;
    int res = solution.maxScore2(nums, x);
    cout << res;
}
