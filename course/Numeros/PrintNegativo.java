package Numeros;

import java.util.ArrayList;
import java.util.List;

public class PrintNegativo {
	
	public static void main(String[] args) {
	     List<Integer> list = new ArrayList<>();
	     list.add(-5);
	     list.add(0);
	     list.add(5);
	     list.removeIf(e -> e < 0);
	     list.forEach(x -> System.out.println(x));
	  } 

}
