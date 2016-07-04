import java.util.Arrays;

public class FastCollinearPoints {
	private Point[] ps;
	private int count;
	private LineSegment[] ls = new LineSegment[1];
	public FastCollinearPoints(Point[] points) {
		if (points == null) throw new java.lang.NullPointerException();
		for (int i = 0; i < points.length-1; i++) {
			if (points[i] == null) throw new java.lang.NullPointerException();
			for (int j = i +1; j<points.length; j++) {
				if (points[i].compareTo(points[j]) == 0) throw new java.lang.IllegalArgumentException();
			}
		}
		ps = points;
	}    // finds all line segments containing 4 or more points
	public int numberOfSegments() {return count;}        // the number of line segments
	public LineSegment[] segments() {
		Point[] auv = new Point[ps.length];
		for (int a = 0; a< auv.length; a++) {auv[a] = ps[a];}
		for (int i = 0; i < ps.length; i++) {
			Arrays.sort(auv, ps[i].slopeOrder());
			int l = 2;
			for (int j = 1; j< ps.length-1; j++) {
				if (ps[i].slopeOrder().compare(auv[j], auv[j+1]) == 0 && j != ps.length-2 ) {
					l++;
					if (l == 4) count++;
				}
				else {
					int offset = 1;
					if (ps[i].slopeOrder().compare(auv[j], auv[j+1]) == 0) {
						l++;
						offset = 2;
						if (l == 4) count++;						
					}
					if (l >= 4) {
						Point[] oneSeg = new Point[l];
						oneSeg[0] = ps[i];
						for (int m = 1; m< l; m++) {
							oneSeg[m] = auv[j + offset - m];
						}
						Arrays.sort(oneSeg);
						boolean norepeate = true;
						
						if (count>1) {
							for (int n = 0; n< count-1; n++) {
								if (ls[n].p.compareTo(oneSeg[0]) == 0 && ls[n].q.compareTo(oneSeg[l-1]) == 0) {
									norepeate = false;
									count --;
								}
							}
						}	
						
						if (count == ls.length) {
							LineSegment[] copy = new LineSegment[2*ls.length];
							for (int x = 0; x < ls.length; x++) {
								copy[x] = ls[x];
							}
							ls = copy;
						}
						
						if (norepeate) {ls[count-1] = new LineSegment(oneSeg[0], oneSeg[l-1]);}
					}
					l = 2;
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
	public static void main (String[] args) {
//		Point[] points = new Point[10];
//		points[0] = new Point (4000 ,30000);//4000 30000
//		points[1] = new Point (3500 ,28000);
//		points[2] = new Point (3000, 26000);
//		points[3] = new Point (2000, 22000);
//		points[4] = new Point (1000, 18000);
//		points[5] = new Point (13000, 21000);
//		points[6] = new Point (23000, 16000);
//		points[7] = new Point (28000, 13500);
//		points[8] = new Point (28000,  5000);
//		points[9] = new Point (28000,  1000);
//		StdDraw.show(0);
//	    StdDraw.setXscale(0, 32768);
//	    StdDraw.setYscale(0, 32768);
//	    StdDraw.show();
//		FastCollinearPoints bcp = new FastCollinearPoints(points);
//		for (LineSegment segment : bcp.segments()) {
//	        StdOut.println(segment);
//	        segment.draw();
//	    	segment.p.draw();
//	    	segment.q.draw();
//	    }
//		StdOut.println(bcp.numberOfSegments());
//	
	int[] q = {3,4,2,1,7,2,5,6};
	int max = 0;
	int N = 8;
	for (int i = 0; i<8; i++ ){
		if (q[max] < q[i] ) max = i;
	}
	int ex = q[max] ; 
	q[max] = q[N -1];
	q[N - 1] = ex;
	int result =  q[--N];
	StdOut.println(result);
	StdOut.println("Am I here???");
	}//unit test
}
