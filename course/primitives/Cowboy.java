package primitives;

public class Cowboy {
	
	private int space = 5;
	
	
	private double ship = space < 2 ? 3L : 10.0f;  // g1
	
	private double ship2 = 3L;
	
	public void printMessage() {
		var var = "";
		var = "wewe";
	      if(ship>1) {
	         System.out.print("Goodbye!");
	      } 
	      if(ship<10 && space>=2)                   // g2
	         System.out.print("Hello!");
	      else System.out.print("See you again!");
	 }
	   
	public static final void main(StringT... stars) {
	      new Cowboy().printMessage();
	   }

}
