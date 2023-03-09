package HJ027;

import java.util.*;

/**
 * HJ27 查找兄弟单词
 *
 * @Site <a href="https://www.nowcoder.com/practice/03ba8aeeef73400ca7a37a5f3370fe68"/>
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] p = in.nextLine().split(" ");
            int n = Integer.parseInt(p[0]);
            String x = p[n + 1];
            int k = Integer.parseInt(p[n + 2]);

            char[] xChars = x.toCharArray();
            Arrays.sort(xChars);

            String[] brothers = new String[n];
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                if (!p[i].equals(x)) {
                    char[] chars = p[i].toCharArray();
                    Arrays.sort(chars);
                    if (Arrays.equals(xChars, chars)) {
                        brothers[cnt++] = p[i];
                    }
                }
            }
            Arrays.sort(brothers, 0, cnt);
            System.out.println(cnt);
            if (k <= cnt) {
                System.out.println(brothers[k - 1]);
            }
        }
    }
}
