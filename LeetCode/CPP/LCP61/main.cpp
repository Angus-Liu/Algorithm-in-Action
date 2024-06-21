#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int temperatureTrend(vector<int>& temperatureA, vector<int>& temperatureB) {
        auto cmp = [](const int a, const int b) -> int {
            return a > b ? 1 : a < b ? -1 : 0;
        };

        int res = 0, sameTrend = 0;
        for (int i = 1; i < temperatureA.size(); ++i) {
            if (cmp(temperatureA[i], temperatureA[i - 1]) == cmp(temperatureB[i], temperatureB[i - 1])) {
                res = max(res, ++sameTrend);
            } else {
                sameTrend = 0;
            }
        }
        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
