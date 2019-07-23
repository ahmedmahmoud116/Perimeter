package pkj;

public class Point {
		private int x,y;
		Point(int startx,int starty){
			this.x = startx;
			this.y = starty;
		}
		public double distance(Point otherpt) {
			double dx = this.x - otherpt.x;
			double dy = this.y - otherpt.y;
			double distance = Math.sqrt(dx*dx+dy*dy);
			return distance;
		}
		public int getX() {
			return this.x;
		}
		public int getY() {
			return this.y;
		}
		public String toString() {
			String ln = "(" + this.x + "," + this.y + ")";
			return ln;
		}
}
