
public class LineSegment {
	Point p,q;
	public LineSegment (Point p, Point q) { 
		if ( p == null || q == null ) throw new java.lang.NullPointerException("argument is null");
		this.p = p; 
		this.q = q;
		}
	public void draw () {p.drawTo(q);}
	public String toString () {
		return p + " -> " + q;
	}
	public int hashCode() {
        throw new UnsupportedOperationException();
    }
}
