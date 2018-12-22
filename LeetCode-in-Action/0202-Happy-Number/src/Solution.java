import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            n = toSumOfSquares(n);
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return true;
    }

    private int toSumOfSquares(int n) {
        int sum = 0;
        do {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        } while (n > 0);

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean happy = solution.isHappy(19);
        System.out.println(happy);
    }
}