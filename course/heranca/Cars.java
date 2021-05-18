package heranca;

public class Cars {
	static {
		System.out.println("static");
	}
	
	class CarsT {
		
	}
	
		   private static void drive() {
		       
		       System.out.println("fast");
		       { 
		    	   System.out.println("faster"); 
		    }
		 
		   }
		   public static void main(String[] args) {
		      drive();
		      drive();
		   }

}
