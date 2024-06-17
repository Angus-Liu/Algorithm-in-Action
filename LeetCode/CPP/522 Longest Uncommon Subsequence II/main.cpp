#include <iostream>
#include <unordered_set>

using namespace std;

class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        auto isSubSeq = [](const string& s, const string& t)-> bool {
            int sp = 0, tp = 0;
            const int tn = static_cast<int>(t.size());
            const int sn = static_cast<int>(s.size());
            while (sp < sn && tp < tn) {
                if (s[sp] == t[tp]) {
                    sp++;
                }
                tp++;
            }
            return sp == sn;
        };

        const int n = static_cast<int>(strs.size());
        int res = -1;
        for (int i = 0; i < n; ++i) {
            bool check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubSeq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                res = max(res, static_cast<int>(strs[i].size()));
            }
        }
        return res;
    }
};

int main() {
    vector<string> strs = {"aba", "cdc", "eae"};
    Solution solution;
    int res = solution.findLUSlength(strs);
    std::cout << res << std::endl;
    return 0;
}
