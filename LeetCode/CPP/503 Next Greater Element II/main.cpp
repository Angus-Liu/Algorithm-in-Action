#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> res;
        res.resize(nums.size());
        for (int& re: res) {
            re = INT_MIN;
        }

        int n = nums.size();
        for (int i = n - 1; i >= 0; --i) {
            if (i < n - 1 && nums[i + 1] > nums[i]) {
                res[i] = nums[i + 1];
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (res[j] > nums[i]) {
                    res[i] = res[j];
                    break;
                }
            }
            if (res[i] != INT_MIN) continue;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
            if (res[i] == INT_MIN) res[i] = -1;
        }
        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
