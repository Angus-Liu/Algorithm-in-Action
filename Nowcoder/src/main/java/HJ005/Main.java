package HJ005;

import java.util.Scanner;

/**
 * HJ5 进制转换
 *
 * @Site <a href="https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6"/>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String hexStr = in.nextLine().substring(2); // 去掉开头的 "0x"
            System.out.println(Integer.parseInt(hexStr, 16));
        }
    }
}