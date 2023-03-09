package HJ023;

import java.util.Scanner;

/**
 * HJ23 删除字符串中出现次数最少的字符
 *
 * @Site <a href="https://www.nowcoder.com/practice/05182d328eb848dda7fdd5e029a56da9"/>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int[] cnt = new int[26];
            int n = s.length();
            for (int i = 0; i < n; i++) {
                cnt[s.charAt(i) - 'a']++;
            }
            int min = n;
            for (int c : cnt) {
                if (c != 0) min = Math.min(min, c);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (cnt[c - 'a'] != min) sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
