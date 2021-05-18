package Collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Yellow {
	
		   public static void main(String[] args) {
		      List list = Arrays.asList("Sunny");
		      method(list);                                // c1
		   }
		   
		   private static void method(Collection<?> x) {   // c2
		      x.forEach(a -> {});                          // c3
		  }

}
