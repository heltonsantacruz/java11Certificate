package tests;

public interface Piano {
	String type = "Grand";

	void play();
	
	public static int getNumberOfKeys() {
		return type.equals("Grand") ? 88 : 61;
	}

	private static void printPianoInfo() {
       play();
       System.out.println("Key Count: "+getNumberOfKeys());
    }
    
	default void tune() {
       play();
       printPianoInfo();
   } 
}