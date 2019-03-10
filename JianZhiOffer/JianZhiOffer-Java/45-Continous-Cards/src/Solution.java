import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) return false;
        Arrays.sort(numbers);
        // 记录空缺数
        int vacancyCount = 0;
        // 记录大小王的个数
        int kingCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) kingCount++;
            else if (i + 1 < numbers.length) {
                // 两数相等，不可能是顺子
                if (numbers[i] == numbers[i + 1]) return false;
                vacancyCount += numbers[i + 1] - numbers[i] - 1;
            }
        }
        return kingCount >= vacancyCount;
    }
}