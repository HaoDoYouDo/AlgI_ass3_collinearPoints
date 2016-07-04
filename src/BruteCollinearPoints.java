import java.util.Arrays;
import edu.princeton.cs.algs4.StdDraw;

public class BruteCollinearPoints {
	private Point[] points;
	private int count; 
	private LineSegment[] ls =new LineSegment[1];
	public BruteCollinearPoints(Point[] points) {
		if (points == null) throw new java.lang.NullPointerException();
		for (int i = 0; i < points.length-1; i++) {
			if (points[i] == null) throw new java.lang.NullPointerException();
			for (int j = i +1; j<points.length; j++) {
				if (points[i].compareTo(points[j]) == 0) throw new java.lang.IllegalArgumentException();
			}
		}
		this.points = points;
	}    // finds all line segments containing 4 points
	public int numberOfSegments() {
		return count;
	}       // the number of line segments
	public LineSegment[] segments() {		
		for (int i = 0 ; i< points.length; i++) {
			for (int j = i+1; j< points.length; j++) {
				for (int k = j+1; k< points.length; k++) {
					for (int l = k+1; l< points.length; l++) {
							if (points[i].slopeOrder().compare(points[j],points[k]) == 0
									&& points[i].slopeOrder().compare(points[k],points[l]) == 0) {
								Point[] Segpoints = {points[i], points[j], points[k], points[l]};
								Arrays.sort(Segpoints);
								if (count == ls.length) {
									LineSegment[] copy = new LineSegment[2*ls.length];
									for (int x = 0; x < ls.length; x++) {
										copy[x] = ls[x];
									}
									ls = copy;
								}
								ls[count++] = new LineSegment(Segpoints[0], Segpoints[3]);
							}
					}
				}
			}
		}
		LineSegment[] copy = new LineSegment[count];
		for (int a = 0; a< count; a++) {
			copy[a] = ls[a];
		}
		ls = copy;
		return ls;
	}               // the line segments
//	public static void main (String[] args) {
////		Point[] points = new Point[4];
////		points[0] = new Point (4000 ,30000);//4000 30000
////		points[1] = new Point (3500 ,28000);
////		points[2] = new Point (3000, 26000);
////		points[3] = new Point (1000, 18000);
////		StdOut.println(points[0].slopeTo(points[1]));
////		StdOut.println(points[0].slopeTo(points[2]));
////		StdOut.println(points[0].slopeTo(points[3]));
////		StdOut.println(points[0].slopeTo(points[1]));
////		Point p2 = new Point (2 ,3);
////		Point p3 = new Point (2 ,4);
////		Point p4 = new Point (2 ,1);
////		if (points[0].slopeOrder().compare(points[1],points[2]) == 0
////				&& points[0].slopeOrder().compare(points[2],points[3]) == 0) {
////			StdOut.println("yes");
////		}
////		else StdOut.println("no");
//		In in = new In("collinear/grid4x4.txt");
//	    int N = in.readInt();
//	    Point[] points = new Point[N];
//	    for (int i = 0; i < N; i++) {
//	        int x = in.readInt();
//	        int y = in.readInt();
//	        points[i] = new Point(x, y);
//	    }
//		
//		BruteCollinearPoints bcp = new BruteCollinearPoints(points);
//		LineSegment[] ls = bcp.segments();
//		StdOut.println(bcp.numberOfSegments());
//	}//unit test
}


