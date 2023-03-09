package HJ068;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * HJ68 成绩排序
 *
 * @Site <a href="https://www.nowcoder.com/practice/8e400fd9905747e4acc2aeed7240978b"/>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            int order = Integer.parseInt(in.nextLine());
            String[][] grads = new String[n][2];
            for (int i = 0; i < n; i++) {
                grads[i] = in.nextLine().split(" ");
            }
            if (order == 0) {
                Arrays.stream(grads)
                        .sorted((g1, g2) -> Integer.parseInt(g2[1]) - Integer.parseInt(g1[1]))
                        .forEach(g -> System.out.println(g[0] + " " + g[1]));
            } else {
                Arrays.stream(grads)
                        .sorted(Comparator.comparing(g -> Integer.parseInt(g[1])))
                        .forEach(g -> System.out.println(g[0] + " " + g[1]));
            }
        }
    }
}