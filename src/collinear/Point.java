package collinear;

import edu.princeton.cs.algs4.*;
import java.util.Comparator;

public class Point implements Comparable<Point> {

    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();

    private class SlopeOrder implements Comparator<Point> {

        @Override
        public int compare(Point p1, Point p2) {
            double slope_p1 = slopeTo(p1);
            double slope_p2 = slopeTo(p2);
            if ((slope_p1) == (slope_p2)) {
                return 0;
            } else if ((slope_p1) > (slope_p2)) {
                return 1;
            } else
                return -1;
        }
    }

    private final int x; // x coordinate
    private final int y; // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        double slope = 0;
        if ((this.y == that.y) && (this.x == that.x)) {
            slope = Double.NEGATIVE_INFINITY;
        } else if (this.y == that.y) {
            slope = +0.0;
        } else if (this.x == that.x) {
            slope = Double.POSITIVE_INFINITY;
        } else
            slope = (((double) this.y - (double) that.y) / ((double) this.x - (double) that.x));
        return slope;

    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    @Override
    public int compareTo(Point that) {
        if ((this.y == that.y) && (this.x == that.x))
            return 0;
        else if ((this.y < that.y) || ((this.y == that.y) && (this.x < that.x))) {
            return -1;
        } else
            return 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {

        Point P = new Point(144, 272);
        Point Q = new Point(111, 272);
        System.out.print(P.slopeTo(Q) + " ");

    }

}
