package chapter_01;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class E_1_2_1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // 10

        Point2D[] points = new Point2D[n];
        drawAndCreatePoints(points);

        StdOut.printf("The shortest distance is: %.3f", calculateShortestDistance(points));
    }

    private static void drawAndCreatePoints(Point2D[] points) {
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(.015);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        for (int i = 0; i < points.length; i++) {
            double pointX = StdRandom.uniform();
            double pointY = StdRandom.uniform();

            Point2D point = new Point2D(pointX, pointY);
            StdDraw.point(point.x(), point.y()); //The exercise doesn't require drawing, but it adds a nice touch

            points[i] = point;
        }
    }

    private static double calculateShortestDistance(Point2D[] points) {
        double shortestDistance = Double.MAX_VALUE;
        double currentDistance;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                currentDistance = points[i].distanceTo(points[j]);

                if (currentDistance < shortestDistance) {
                    shortestDistance = currentDistance;
                }
            }
        }
        return shortestDistance;
    }
}
