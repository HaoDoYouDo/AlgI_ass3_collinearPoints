
public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read the N points from a file
//	    In in = new In(args[0]);
		In in = new In("collinear/rs1423.txt");
	    int N = in.readInt();
	    Point[] points = new Point[N];
	    for (int i = 0; i < N; i++) {
	        int x = in.readInt();
	        int y = in.readInt();
	        points[i] = new Point(x, y);
	    }

	    // draw the points
	    StdDraw.show(0);
	    StdDraw.setXscale(0, 32768);
	    StdDraw.setYscale(0, 32768);
	    for (Point p : points) {
	        p.draw();
	    }
	    StdDraw.show();

	    // print and draw the line segments
//	    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
	    FastCollinearPoints collinear = new FastCollinearPoints(points);
	    
	    for (LineSegment segment : collinear.segments()) {
	        StdOut.println(segment);
	        segment.draw();
	    	segment.p.draw();
	    	segment.q.draw();
	    }
	    StdOut.println(collinear.numberOfSegments());
	    
	   
	}

}
