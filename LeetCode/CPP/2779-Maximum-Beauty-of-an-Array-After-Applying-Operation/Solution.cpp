#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maximumBeauty(vector<int> &nums, int k) {
        ranges::sort(nums);
        int res = 0, span = 2 * k;
        for (int l = 0, r = 0; r < nums.size(); r++) {
            if (nums[r] - nums[l] <= span) {
                res = max(res, r - l + 1);
            } else {
                l++;
            }
        }
        return res;
    }
};


int main(int argc, char *argv[]) {
}
