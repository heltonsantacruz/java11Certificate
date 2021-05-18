package IO;

import java.util.Scanner;

public class Fortress {
	
	
	public void openDrawbridge() throws Exception {  // p1
	      try {
	         throw new Exception("Circle");             // p2
	      } catch (Exception | Error e) {
	         System.out.print("Opening!");
	      } finally {
	         System.out.print("Walls");
	      }
	   }
	
	public static void main(String[] moat) {
	      try (var e = new Scanner(System.in)) {
	        // new Fortress().openDrawbridge();           // p3
	      }
	   }

}
