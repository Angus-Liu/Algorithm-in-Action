#include <iomanip>
#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

class Solution {
public:
    string discountPrices(string sentence, int discount) {
        ostringstream out;
        out << fixed << setprecision(2);
        // split sentence
        double discountFact = (100.0 - discount) / 100.0;
        istringstream iss(sentence);
        string word;
        while (iss >> word) {
            if (word[0] == '$' && word.size() > 1
                && all_of(word.begin() + 1, word.end(), ::isdigit)) {
                out << "$" << stod(word.substr(1)) * discountFact;
            } else {
                out << word;
            }
            out << " ";
        }
        string res = out.str();
        res.pop_back();
        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
