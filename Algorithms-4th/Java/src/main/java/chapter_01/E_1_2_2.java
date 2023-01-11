package chapter_01;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个 Interval1D 的用例，从命令行接受一个整数 N。
 * 从标准输入中读取 N 个间隔（每个间隔 由一对 double 值定义）并打印出所有相交的间隔对。
 */
public class E_1_2_2 {
    public static void main(String[] args) {
        int N = 3; // default
        if (args.length > 0) {
            N = Integer.parseInt(args[0]);
        }
        Interval1D[] intervals = getIntervals(N);
        calcIntersects(intervals);
    }

    private static Interval1D[] getIntervals(int N) {
        Interval1D[] intervals = new Interval1D[N];
        for (int i = 0; i < intervals.length; i++) {
            StdOut.printf("Please input the %d interval: ", i);
            double min = StdIn.readDouble();
            double max = StdIn.readDouble();
            intervals[i] = new Interval1D(min, max);
        }
        StdOut.println("The intervals are: ");
        for (int i = 0; i < intervals.length; i++) {
            StdOut.printf("%d - %s\n", i, intervals[i]);
        }
        return intervals;
    }

    private static void calcIntersects(Interval1D[] intervals) {
        StdOut.println("The intersects are:");
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.printf("%d - %s & %d - %s\n", i, intervals[i], j, intervals[j]);
                }
            }
        }
    }
}
