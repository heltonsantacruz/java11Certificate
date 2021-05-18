package Instances;

	
public class InitOrder {
	   { 
		   System.out.print('1'); 
	   }
	   
	   static { 
		   System.out.print('2'); 
	   }
	 
	   public InitOrder() {
	      System.out.print('3');
	   }
	   
	   public static void callMe() {
	      System.out.print('4');
	   }
	   
	   public static void main(String[] args) {
		   var var = "";
		   var = "6";
		   double f = 4f;
		   InitOrder i = new InitOrder();
		   callMe();
		   callMe();
		   System.out.println('5');
		   i.callMe();
		   System.out.println('6');
		   InitOrder i2 = new InitOrder();
	   }

}
