#include <iostream>
#include <unordered_set>
#include <vector>
#include <stack>
#include <unordered_map>

using namespace std;

// class Solution {
// public:
//     long long findMaximumElegance(vector<vector<int> > &items, int k) {
//         unordered_set<int> idxes;
//         unordered_map<int, int> categories;
//         dfs(items, k, idxes, categories);
//         return res;
//     }
//
// private:
//     long long res = 0;
//
//     void dfs(vector<vector<int> > &items, int k, unordered_set<int> &idxes, unordered_map<int, int> &categories) {
//         if (k == 0) {
//             long long elegance = categories.size() * categories.size();
//             for (const auto idx: idxes) {
//                 elegance += items[idx][0];
//             }
//             res = elegance > res ? elegance : res;
//             return;
//         }
//         for (int i = 0; i < items.size(); i++) {
//             if (idxes.contains(i)) continue;
//             idxes.emplace(i);
//             int cat = items[i][1];
//             categories[cat] = categories[cat] + 1;
//             dfs(items, k - 1, idxes, categories);
//             idxes.erase(i);
//             categories[cat] = categories[cat] - 1;
//             if (categories[cat] == 0) categories.erase(cat);
//         }
//     }
// };

class Solution {
public:
    long long findMaximumElegance(vector<vector<int> > &items, int k) {
        sort(items.begin(), items.end(), [&](auto const i1, auto const i2) { return i1[0] > i2[0]; });
        unordered_set<int> categoryies;
        long long res = 0, profit = 0;
        stack<int> st;
        for (int i = 0; i < items.size(); ++i) {
            if (i < k) {
                profit += items[i][0];
                if (!categoryies.contains(items[i][1])) {
                    categoryies.insert(items[i][1]);
                } else {
                    st.push(items[i][0]);
                }
            } else if (!categoryies.contains(items[i][1]) && !st.empty()) {
                profit += items[i][0] - st.top();
                st.pop();
                categoryies.insert(items[i][1]);
            }
            res = max(res, (long long) (profit + categoryies.size() * categoryies.size()));
        }
        return res;
    }
};
