#include <iostream>
#include <vector>
#include <__numeric/gcd_lcm.h>

using namespace std;

class Solution {
public:
    int countBeautifulPairs(vector<int>& nums) {
        int res = 0, n = nums.size();
        for (int i = 0; i < n - 1; ++i) {
            while (nums[i] >= 10) {
                nums[i] /= 10;
            }
            for (int j = i + 1; j < n; ++j) {
                if (gcd(nums[i], nums[j] % 10) == 1) {
                    res++;
                }
            }
        }
        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
