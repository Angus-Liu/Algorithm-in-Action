#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int numRescueBoats(vector<int> &people, int limit) {
        ranges::sort(people);
        const int n = static_cast<int>(people.size());
        int res = 0;
        for (int i = 0, j = n - 1; i <= j; res++, j--) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    Solution solution;
    vector people{3, 5, 3, 4};
    int num = solution.numRescueBoats(people, 5);
    std::cout << num;
}
