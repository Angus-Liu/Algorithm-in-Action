#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    long long countCompleteDayPairs(vector<int> &hours) {
        // 用来记录每个模数出现的次数
        unordered_map<int, int> remainderCount;
        long long count = 0;
        for (const auto &hour: hours) {
            int remainder = hour % 24;
            int complement = (24 - remainder) % 24; // 对于0的情况，complement应为0
            // 如果哈希表中存在 complement，则累加配对数量
            if (remainderCount.contains(complement)) {
                count += remainderCount[complement];
            }
            // 记录当前小时数的模数出现次数
            remainderCount[remainder]++;
        }
        return count;
    }
};

int main(int argc, char *argv[]) {
    vector<int> hours = {12, 12, 30, 24, 24};
    Solution solution;
    auto res = solution.countCompleteDayPairs(hours);
    cout << "res = " << res << endl;
}
