package chapter_01.section_02;

import edu.princeton.cs.algs4.*;

public class E_1_2_1 {
    public static void main(String[] args) {
        int N = 100; // default
        if (args.length != 0) N = Integer.parseInt(args[0]);
        Point2D[] points = getPoints(N);
        showPoints(points);
        double shortestDist = calcShortestDist(points);
        StdOut.printf("The shortest distance is: %.3f", shortestDist);
    }

    private static Point2D[] getPoints(int N) {
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            points[i] = new Point2D(x, y);
        }
        return points;
    }

    private static void showPoints(Point2D[] points) {
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        for (Point2D point : points) {
            StdDraw.point(point.x(), point.y());
        }
    }

    private static double calcShortestDist(Point2D[] points) {
        double shortestDist = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                shortestDist = Math.min(shortestDist, points[i].distanceTo(points[j]));
            }
        }
        return shortestDist;
    }
}
