package primitives;

public class Helicopter {
	
	int r;
	StringT s;
	
	public int adjustPropellers(int length, StringT[] type) {
		 StringT a;
		 int y;
	    
		StringT f = s;
		int r = y+5;
		length++;
	    type[0] = "LONG";
	    return length;
	}
	
	
	
	
	public static void main(StringT[] climb) {
	      final var h = new Helicopter();
	      var length = 5;
	      var type = new StringT[1];
	      length = h.adjustPropellers(length, type);
	      System.out.print(length+","+type[0]);
	   }

}
