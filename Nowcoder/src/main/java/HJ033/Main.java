package HJ033;

import java.util.Scanner;

/**
 * HJ33 整数与IP地址间的转换
 *
 * @Site <a href="https://www.nowcoder.com/practice/66ca0e28f90c42a196afd78cc9c496ea"/>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String origin = in.nextLine();
            if (origin.contains(".")) {
                long num = 0;
                for (String addr : origin.split("\\.")) {
                    // num = (num << 8) + Integer.parseInt(addr);
                    num = (num << 8) | Integer.parseInt(addr);
                }
                System.out.println(num);
            } else {
                long num = Long.parseLong(origin);
                StringBuilder sb = new StringBuilder();
                // int div = 256 << 16;
                // sb.append(num / div).append('.');
                // num %= div;
                // div >>= 8;
                // sb.append(num / div).append('.');
                // num %= div;
                // div >>= 8;
                // sb.append(num / div).append('.');
                // num %= div;
                // div >>= 8;
                // sb.append(num / div);
                sb.append((num >> 24) & 0xFF).append('.');
                sb.append((num >> 16) & 0xFF).append('.');
                sb.append((num >> 8) & 0xFF).append('.');
                sb.append(num & 0xFF);
                System.out.println(sb);
            }
        }
    }
}
