#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int countCompleteDayPairs(vector<int> &hours) {
        int res = 0, n = hours.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) res++;
            }
        }
        return res;
    }
};
