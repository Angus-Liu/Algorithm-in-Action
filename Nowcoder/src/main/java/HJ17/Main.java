package HJ17;

import java.util.Scanner;

/**
 * HJ17 坐标移动
 *
 * @Site <a href="https://www.nowcoder.com/practice/119bcca3befb405fbe58abe9c532eb29"/>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int[] point = new int[2];
            String coords = in.nextLine();
            for (String c : coords.split(";")) {
                if (c.length() < 2 || c.length() > 3) continue;
                try {
                    int step = Integer.parseInt(c.substring(1));
                    //    W
                    // A  +  D
                    //    S
                    switch (c.charAt(0)) {
                        case 'A':
                            point[0] -= step;
                            break;
                        case 'D':
                            point[0] += step;
                            break;
                        case 'W':
                            point[1] += step;
                            break;
                        case 'S':
                            point[1] -= step;
                            break;
                    }
                } catch (Exception e) {
                    // ignore
                }
            }
            System.out.println(point[0] + "," + point[1]);
        }
    }
}
