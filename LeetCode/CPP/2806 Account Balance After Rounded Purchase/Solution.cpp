#include <iostream>

class Solution {
public:
    int accountBalanceAfterPurchase1(int purchaseAmount) {
        int remainder = purchaseAmount % 10;
        return 100 - (remainder < 5 ? purchaseAmount - remainder : purchaseAmount - remainder + 10);
    }

    int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - (purchaseAmount + 5) / 10 * 10;
    }
};

int main() {
    Solution solution;
    int res = solution.accountBalanceAfterPurchase(9);
    std::cout << res << std::endl;
    res = solution.accountBalanceAfterPurchase(15);
    std::cout << res << std::endl;
    return 0;
}
