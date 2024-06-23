#include <iostream>

using namespace std;

class Solution {
public:
    bool detectCapitalUse(string word) {
        int upperCnt = ranges::count_if(word, [](char c) { return isupper(c); });
        return upperCnt == 0 || (upperCnt == 1 && isupper(word[0])) || upperCnt == word.size();
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
