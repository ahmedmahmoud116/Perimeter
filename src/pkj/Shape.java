package pkj;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Shape {
		private ArrayList<Point> al = new ArrayList<>();
		
		public Shape(){
		}
		
		public Shape(File f) throws FileNotFoundException{
		 Scanner sc = new Scanner(f);
		 Point p;
			while(sc.hasNext()){
				String ln = sc.next();
				String[] ln2 = ln.split(",");
				int x = Integer.parseInt(ln2[0]);
				int y = Integer.parseInt(ln2[1]);
				p = new Point(x,y);
				al.add(p);
			}
		}
		
		public void addPoint(Point p) {
		 al.add(p);
		}
		public Point getLastPoint() {
			return al.get(al.size() - 1);
		}
		public Iterable<Point> getPoints(){
			Iterable<Point> iterab = al;
			return iterab;
		}
}
