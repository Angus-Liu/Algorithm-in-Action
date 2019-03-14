import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Solution {

    /**
     * 利用短路运算的性质判断递归结束条件
     */
    public int Sum_Solution_1(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    /**
     * 利用库函数
     */
    public int Sum_Solution_2(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }

    /**
     * 利用流
     */
    public int Sum_Solution(int n) {
        AtomicInteger sum = new AtomicInteger();
        IntStream.range(1, n + 1)
                .reduce((a, b) -> a + b)
                .ifPresent(sum::set);
        return sum.get();
    }

    public static void main(String[] args) {
        int sum = new Solution().Sum_Solution(15);
        System.out.println("sum = " + sum);
    }
}