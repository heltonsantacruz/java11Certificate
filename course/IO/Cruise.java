package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Cruise {
	
	   private int numPassengers = 1;
	
	   private transient String schedule = "NONE";
	
	   {
		   System.out.println("1"+ numPassengers);
		   numPassengers = 2; 
		   System.out.println("2"+ numPassengers);
	   }
	   
	   
	   public Cruise() {
		   System.out.println("3"+ numPassengers);
	      this.numPassengers = 3;
	      this.schedule = "Tropical Island";
	      System.out.println("4"+ numPassengers);
	      
	   }
	 
	   public static void main(String... p) throws Exception {
	      final String f = "ship.txt";
	      try (var o = new ObjectOutputStream(new FileOutputStream(f))) {
	         Cruise c = new Cruise();
	         System.out.println("5"+ c.numPassengers);
	         c.numPassengers = 4;
	         System.out.println("5"+ c.numPassengers);
	         c.schedule = "Casino";
	         o.writeObject(c);
	      }
	      try (var i = new ObjectInputStream(new FileInputStream(f))) {
	         Cruise c = i.readObject();
	         System.out.print(c.numPassengers + "," + c.schedule);
	      } 
	   }

}
