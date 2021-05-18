package heranca;

import java.util.ArrayList;


public interface Plant {
	
	String[] gems = {"2"};
	//java.util.List<Integer> gems2;
	
	private static String grow() { 
		return "Grow!"; 
	}
	int getT();
	
	String[] color();
	
	public int maker = 5;
	
	private static int getMaxWithdrawal() {
	      return 10;
	   }
	
	
//	private int getX() {
//		return 0;
//	}
//	
//	private static int getR() {
//		return 2;
//	}
//	
//	public default boolean getF() {
//		getX();
//		return false;
//	}
//	
	
}
