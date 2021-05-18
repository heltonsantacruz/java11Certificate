package heranca;

public class Light extends Wave {
	   public int size = 5;
	   
	   
	   public static void main(String... emc2) {
	      Light v1 = new Light();
	      var v2 = new Light();
	      Wave v3 = new Light();
	      System.out.println(v1.size +","+ v2.size +","+ v3.size);
	   }
	}