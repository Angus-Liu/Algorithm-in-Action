package HJ003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * HJ3 明明的随机数
 *
 * @Site <a href="https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0"/>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            List<Integer> nums = new ArrayList<>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                nums.add(in.nextInt());
            }
            nums.stream().sorted().distinct().forEach(System.out::println);
        }
    }
}
