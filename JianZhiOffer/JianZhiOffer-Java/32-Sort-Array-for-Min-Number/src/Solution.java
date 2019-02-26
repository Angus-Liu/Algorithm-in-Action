import java.util.Arrays;

public class Solution {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        // 根据新的排序规则进行排序
        return Arrays.stream(numbers)
                .boxed()
                .sorted((Integer num1, Integer num2) -> {
                    String str1 = num1 + "" + num2;
                    String str2 = num2 + "" + num1;
                    return str1.compareTo(str2);
                })
                .map(String::valueOf)
                .reduce((String str1, String str2) -> str1 + str2)
                .get();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 32, 321, 2, 11};
        String res = new Solution().PrintMinNumber(numbers);
        System.out.println(res);
    }
}