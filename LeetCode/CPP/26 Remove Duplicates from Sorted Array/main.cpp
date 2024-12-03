#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0;
        for (int num: nums) {
            if (num != nums[i]) nums[++i] = num;
        }
        return i + 1;
    }
};

int main() {
    vector<int> nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    Solution solution;
    solution.removeDuplicates(nums);

    for (int num : nums) {
        cout << num << " ";
    }
}
