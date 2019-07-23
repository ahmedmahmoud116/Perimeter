package pkj;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CalcPerimeter extends JFrame{
	
		public CalcPerimeter() {
			
		}
		public double getPerimeter(Shape s) {
			double totalPerim = 0;
			Point prevp = s.getLastPoint();
			for(Point p: s.getPoints()) {
				totalPerim = totalPerim + p.distance(prevp);
				prevp = p;
			}
			return totalPerim;
		}
		
		public void testPerimeter() throws FileNotFoundException {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
			    File f = fileChooser.getSelectedFile();
			    CalcPerimeter p = new CalcPerimeter();
			    System.out.println(p.getPerimeter(new Shape(f)));
			}
			
		}
		
		public void triangle() throws FileNotFoundException {
			Shape triangle = new Shape();
			File f = new File("C:\\Users\\lenovo\\Documents\\Downloads\\Compressed\\Java1\\perimeter_quiz\\datatest4.txt");
			Shape s = new Shape(f);
	
			triangle.addPoint(new Point(0,0));
			triangle.addPoint(new Point(0,4));
			triangle.addPoint(new Point(3,0));
			
			System.out.println("Triangle points: ");
			for(Point p: triangle.getPoints()) {
				System.out.println(p);
			}
			
			System.out.println("Perimeter of the Shape: " + new CalcPerimeter().getPerimeter(s));
			
			System.out.println("Number of points of the Shape: " + new CalcPerimeter().getNumPoints(s));
			
			System.out.println("Average Length of the Shape: " + new CalcPerimeter().getAverageLength(s));
	
			System.out.println("Largest Side of the Shape: " + new CalcPerimeter().getLargestSide(s));
			
			System.out.println("Largest X of the Shape: " + new CalcPerimeter().getLargestX(s));
		}
		
		public int getNumPoints(Shape s) {
			int num = 0;
			for(@SuppressWarnings("unused") Point p: s.getPoints()) {
				num++;
			}
			return num;
		}
		
		public double getAverageLength(Shape s) {
			CalcPerimeter p = new CalcPerimeter();
			double avg = p.getPerimeter(s) / p.getNumPoints(s);
			return avg;
		}
		
		public double getLargestSide(Shape s) {
			Point prevp = s.getLastPoint();
			double max = 0;
			for(Point po:s.getPoints()) {
				if(max < po.distance(prevp))
					max = po.distance(prevp);
				prevp = po; 
			}
				return max;
		}
		
		public double getLargestX(Shape s) {
			double max = 0;
			for(Point currp: s.getPoints()) {
				if(max < currp.getX())
					max = currp.getX();
			}
			return max;
		}
		
		public void printFileNames() {
			DirectoryResource dr = new DirectoryResource();
			for(File f: dr.selectedFiles()) {
				System.out.println(f.getName());
			}
		}
		
		public double getLargestPerimeterMultipleFiles() throws FileNotFoundException {
			DirectoryResource dr = new DirectoryResource();
			double max = 0;
			for(File f: dr.selectedFiles()) {
				Shape s = new Shape(f);
				CalcPerimeter p =  new CalcPerimeter();
				if(max<p.getPerimeter(s))
					max = p.getPerimeter(s);
			}
			return max;
		}
		
		public void testPerimeterMultipleFiles() throws FileNotFoundException{
			CalcPerimeter p = new CalcPerimeter();
			System.out.println("The largest perimeter of These Files: " + p.getLargestPerimeterMultipleFiles());
		}
		
		public File getFileWithLargestPerimeter() throws FileNotFoundException {
			DirectoryResource dr = new DirectoryResource();
			File fl = null;
			double max = 0;
			for(File f : dr.selectedFiles()) {
				Shape s = new Shape(f);
				CalcPerimeter p =  new CalcPerimeter();
				if(max < p.getPerimeter(s))
				{
					max = p.getPerimeter(s);
					fl = f;
				}
			}
			return fl;
}
		
		public void testFileWithLargestPerimeter() throws FileNotFoundException{
			CalcPerimeter p = new CalcPerimeter();
			System.out.println("The name of File that has the largest perimeter of These Files: " + p.getFileWithLargestPerimeter().getName());
		}
		public static void main(String[] args){
			CalcPerimeter p = new CalcPerimeter();
			File f = new File("C:\\Users\\lenovo\\Documents\\Downloads\\Compressed\\Java1\\perimeter_quiz\\example1.txt");
			try {
				p.testPerimeterMultipleFiles();
//				p.triangle();
				p.testFileWithLargestPerimeter();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
}
