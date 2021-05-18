package heranca;

import java.util.Collection;
import java.util.List;

public class Transport {
	
	
	    static interface Vehicle {}
	    
	    static class Bus implements Vehicle{}
	    
	
	    public static void main(String[] args) {
	       Bus bus = new Bus();
	
	       //System.out.println(Bus instanceof null);
	       System.out.println(null instanceof Bus);
	       System.out.println(bus instanceof Vehicle);
	       System.out.println(bus instanceof Bus);
	       System.out.println(bus instanceof String);
	       System.out.println(bus instanceof List);
	       System.out.println(bus instanceof Collection);
	    }

}
