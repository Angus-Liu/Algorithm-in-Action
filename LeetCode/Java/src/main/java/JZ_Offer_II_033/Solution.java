package JZ_Offer_II_033;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] hash = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Long, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            long wordHash = 1;
            for (char c : str.toCharArray()) {
                wordHash *= hash[c - 'a'];
            }
            groups.computeIfAbsent(wordHash, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(groups.values());
    }

    private static void genPrimeNumbers(int size) {
        if (size <= 0) {
            System.out.println("Invalid input size");
            return;
        }

        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        for (int i = 3; primes.size() < size; i += 2) {
            boolean isPrime = true;
            double sqrt = Math.sqrt(i);

            for (Integer prime : primes) {
                if (prime > sqrt) {
                    break;
                }
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
            }
        }

        System.out.println(primes);
    }


    public static void main(String[] args) {
        genPrimeNumbers(26);
    }
}
