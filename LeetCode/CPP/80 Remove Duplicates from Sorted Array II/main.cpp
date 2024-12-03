#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int removeDuplicates_1(vector<int>& nums) {
        bool hasTwoSame = false;
        int l = 0;
        for (int r = 1; r < nums.size(); r++) {
            if (nums[r] != nums[l]) {
                hasTwoSame = false;
                nums[++l] = nums[r];
            } else if (!hasTwoSame) {
                hasTwoSame = true;
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }

    int removeDuplicates(vector<int>& nums) {
        if (nums.size() <= 2) return nums.size();
        int l = 1;
        for (int r = 2; r < nums.size(); r++) {
            if (nums[r] != nums[l - 1]) {
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }
};