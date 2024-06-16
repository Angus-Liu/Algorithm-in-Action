#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

class Solution {
public:
    long long maximumTotalDamage(vector<int>& power) {
        ranges::sort(power);
        map<int, int> cntMap;
        for (auto d: power) cntMap[d]++;
        vector<pair<int, int>> damagePairs(cntMap.begin(), cntMap.end());
        const int n = damagePairs.size();
        vector<long long> dp(n + 1);
        for (int i = 0; i < n; i++) {
            auto& [d, c] = damagePairs[i];
            int j = i;
            while (j && damagePairs[j - 1].first >= d - 2) {
                j--;
            }
            dp[i + 1] = max(dp[i], dp[j] + static_cast<long long>(d) * c);
        }

        return dp[n];
    }
};

int main() {
    Solution solution;
    vector<int> power = {1, 1, 3, 4};
    const auto res = solution.maximumTotalDamage(power);
    cout << res;
    return 0;
}
