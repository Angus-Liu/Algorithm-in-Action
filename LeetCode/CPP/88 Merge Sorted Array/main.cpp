#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        m--;
        n--;
        for (int i = m + n + 1; i >= 0 && n >= 0; i--) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums2[n--];
            }
        }
    }
};

int main() {
    Solution solution;
    std::vector<int> nums1 = {1, 2, 3, 0, 0, 0};
    std::vector<int> nums2 = {2, 5, 6};
    solution.merge(nums1, 3, nums2, 3);

    for (int num: nums1) {
        std::cout << num << ' ';
    }
}
