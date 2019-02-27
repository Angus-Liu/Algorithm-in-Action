public class Solution {
    public int GetUglyNumber_Solution_1(int index) {
        int num = 0;
        while (index > 0) {
            if (isUglyNumber(++num)) {
                --index;
            }
        }
        return num;
    }

    private boolean isUglyNumber(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    public int GetUglyNumber_Solution(int index) {
        // 0-6 的丑数就是 index 本身
        if (index < 7) return index;
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2) t2++;
            if (res[i] == res[t3] * 3) t3++;
            if (res[i] == res[t5] * 5) t5++;
        }
        return res[index - 1];
    }

    public static void main(String[] args) {
        int res = new Solution().GetUglyNumber_Solution(1500);
        System.out.println(res);
    }
}