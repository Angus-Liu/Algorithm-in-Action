import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        List<Integer> primeList = new ArrayList<>();
        primeList.add(2);
        for (int i = 3; i < n; i++) {
            boolean isPrime = true;
            for (int j = 0; j < primeList.size(); j++) {
                int prime = primeList.get(j);
                if (prime * prime > j) {
                    break;
                }
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeList.add(i);
            }
        }
        return primeList.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(499979));
    }
}