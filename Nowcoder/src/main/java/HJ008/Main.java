package HJ008;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * HJ8 合并表记录
 *
 * @Site <a href="https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201"/>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int index = in.nextInt();
                int value = in.nextInt();
                map.merge(index, value, Integer::sum);
            }
            StringBuilder sb = new StringBuilder();
            map.forEach((i, v) -> sb.append(i).append(" ").append(v).append("\n"));
            System.out.print(sb);
        }
    }
}
