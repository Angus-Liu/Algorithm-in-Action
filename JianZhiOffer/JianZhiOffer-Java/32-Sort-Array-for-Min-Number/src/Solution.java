import java.util.Arrays;

public class Solution {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        // 根据新的排序规则进行排序
        return Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .sorted((str1, str2) -> (str1 + str2).compareTo(str2 + str1))
                .reduce((str1, str2) -> str1 + str2)
                .get();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 32, 321, 2, 11};
        String res = new Solution().PrintMinNumber(numbers);
        System.out.println(res);
    }
}