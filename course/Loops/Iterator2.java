package Loops;

import java.util.Iterator;
import java.util.List;

public class Iterator2 {
	
	public static void main(String[] args) {
		var lista = List.of(1,2,3,4,5,6);
		Iterator iterator1 =  lista.iterator();
		while (iterator1.hasNext()) {
			iterator1.next();
			
		}
		
		Iterator iterator2 = lista.iterator();
		while (iterator2.hasNext()) {
			iterator1.next();
			
		}
		
		for (Iterator iterator3 = lista.iterator(); iterator1.hasNext();) {
			iterator3.next();
			
		}
		
		
		for (Iterator iterator4 = lista.iterator(); iterator4.hasNext();) {
			iterator3.next();
			
		}
		
		
	}

}
