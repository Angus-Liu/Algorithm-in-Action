#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num != val) nums[i++] = num;
        }
        return i;
    }
};

int main() {
    Solution solution;
    vector<int> v = {0,1,2,2,3,0,4,2};
    int res = solution.removeElement(v, 2);
    cout << "res: " << res << endl;
    for (int num : v) {
        cout << num << " ";
    }
}