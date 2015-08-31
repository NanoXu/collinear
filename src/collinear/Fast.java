package collinear;


import java.util.*;
import edu.princeton.cs.algs4.*;
/*import edu.princeton.cs.algs4.In;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.MinPQ;*/

public class Fast{

    public static void main(String[] args) {
        String filename = "C:/Users/xu/workspace/collinear/src/collinear/input8.txt";//args[0];//"
        In in = new In(filename);
        int N = in.readInt();

        Point[] pointArr = new Point[N];

        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point point = new Point(x, y);
            pointArr[i] = point;
            point.draw();
        }

        // pointArr[0].SLOPE_ORDER=new Comparator();
        // Arrays.sort(pointArr, pointArr[0].SLOPE_ORDER);
        for (int i = 0; i < N; i++) {
            Arrays.sort(pointArr, pointArr[i].SLOPE_ORDER);

            ArrayList<Point> collinear = new ArrayList<Point>(N);
            for (int j = 0; j < N - 1; j++) {
                if (i == j) {
                    continue;
                }
                if (collinear.isEmpty()) {
                    collinear.add(pointArr[j]);
                } else if (pointArr[i].slopeTo(pointArr[j - 1]) == pointArr[i].slopeTo(pointArr[j])) {
                    collinear.add(pointArr[j]);
                } else if (collinear.size() > 2) {
                    collinear.add(pointArr[i]);
                    Collections.sort(collinear);
                    for (int k = 0; k < 3; k++) {
                        StdOut.print(collinear.get(k));
                        StdOut.print(" -> ");
                    }
                    StdOut.println(Collections.max(collinear));
                    Collections.min(collinear).drawTo(Collections.max(collinear));
                    break;
                } else {
                    collinear.clear();
                    collinear.add(pointArr[j]);
                }
            }

            /*
             * for (int n = 0; n < N; n++) { System.out.print(pointArr[i] + " "
             * ); }
             */
        }
    }
}
