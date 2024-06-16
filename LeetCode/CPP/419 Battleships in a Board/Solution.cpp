#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int countBattleships(vector<vector<char> > &board) {
        const int m = static_cast<int>(board.size());
        const int n = static_cast<int>(board[0].size());
        int res = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'X') {
                    if (r > 0 && board[r - 1][c] == 'X') continue;
                    if (c > 0 && board[r][c - 1] == 'X') continue;
                    res++;
                }
            }
        }
        return res;
    }
};

int main() {
    vector<vector<char> > board = {
        {'X', '.', '.', 'X'},
        {'.', '.', '.', 'X'},
        {'.', '.', '.', 'X'}
    };
    Solution solution;
    int res = solution.countBattleships(board);
    std::cout << res;
    return 0;
}
