package chapter_01;

import edu.princeton.cs.algs4.StdOut;

public class E_1_1_6 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            // 输出为斐波那契数
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
