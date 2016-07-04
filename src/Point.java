import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
public class Point implements Comparable<Point>{
	private class Pcomaparator<T> implements Comparator<Point> {
//		Point copy = new Point(x, y);
//		private Point p1, p2;
//		public Pcomaparator (Point p1, Point p2) {
//			this.p1 = p1;
//			this.p2 = p2;
//		}
		@Override
		public int compare(Point o1, Point o2) { 
			// TODO Auto-generated method stub
			if (slopeTo(o1) < slopeTo(o2)) return -1; 
			else if (slopeTo(o1) > slopeTo(o2)) return 1;
			else return 0;
		}

	}
	private final int x, y;
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}	//constructor
	public void draw () {StdDraw.point(x, y);} //draws this point
	public void drawTo (Point that) {StdDraw.line(this.x, this.y, that.x, that.y);} // draws the line segment from this point to that point
	public String toString () {
		return "(" + x + ", " + y + ")";
	} // string representation
	@Override
	public int compareTo(Point that) {
		// TODO  compare two points by y-coordinates, breaking ties by x-coordinates
		if (y <that.y || (y == that.y && x <that.x) ) return -1; // this < that
		else if (y >that.y || (y == that.y && x >that.x) ) return 1; // this > that
		else return 0;
	}
	public double slopeTo (Point that) {
		if (that.y == y && that.x == x) return Double.NEGATIVE_INFINITY;
		else if (that.x == x) return Double.POSITIVE_INFINITY;
		else if (that.y == y) return 0.0/1.0;
		else return (double) (that.y - y)/(that.x - x);
	} //the slope between this point and that point
//	
	public Comparator<Point> slopeOrder() {
		return new Pcomaparator <Point> ();
		
	} //compare two points by slopes they make with this point
	public static void main(String[] args) {
//		Point p1 = new Point (1 ,3);
//		Point p2 = new Point (2 ,3);
//		Point p3 = new Point (2 ,4);
//		Point p4 = new Point (2 ,1);
//		Point[] ps= {p1, p2, p3, p4};
//		Arrays.sort(ps);
// 		for (Point p: ps) {
// 			StdOut.println(p);
// 		}	
		double a = Double.NEGATIVE_INFINITY;
		double b = Double.POSITIVE_INFINITY;
		if (a > b ) StdOut.println(">");
		else if (a < b) StdOut.println("<");
		else StdOut.println(" = ");
	}
}
	
