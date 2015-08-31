package collinear;

import java.util.Arrays;
import edu.princeton.cs.algs4.*;

import java.io.*;

public class Brute {
    
    // @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        String filename = "C:/Users/xu/workspace/collinear/input6.txt";
        In in = new In(filename);
        int N = in.readInt();

        Point[] pointArr = new Point[N];
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show();

        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point point = new Point(x, y);
            pointArr[i] = point;
            point.draw();

        }
        Arrays.sort(pointArr);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {

                        Point point1 = pointArr[i];
                        Point point2 = pointArr[j];
                        Point point3 = pointArr[k];
                        Point point4 = pointArr[l];

                        if (point1.slopeTo(point2) == point2.slopeTo(point3)
                                && point2.slopeTo(point3) == point3.slopeTo(point4) && point1.compareTo(point2) < 1
                                && point2.compareTo(point3) < 1 && point3.compareTo(point4) < 1) {

                            StdOut.println(point1.toString() + " -> " + point2.toString() + " -> " + point3.toString()
                                    + " -> " + point4.toString());

                            point1.drawTo(point4);
                        }
                    }
                }
            }
        }
    }
}
