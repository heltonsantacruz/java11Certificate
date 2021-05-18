package Lambdas;

@FunctionalInterface
public interface Play {
	
	   public static void baseball() {}
	   
	   private static void soccer() {}
	   
	   default void play() {}
	   
	  // void fun();
	   
	   void game();
	   
	   void toy();
	   
	   
	
}
