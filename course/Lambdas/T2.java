package Lambdas;

import java.util.List;

public class T2 {

	
	public static void main(String[] args) {
		var bed = List.of((short)2,(short)5);
		//var bed = List.of(2,5);
		
		var pillow = bed.parallelStream().reduce(0.0,
				//(a,b) -> b + a,
				//(c,d) -> d + c);
				(a,b) -> b.doubleValue() + a.doubleValue(),
				(c,d) -> d.doubleValue() + c.doubleValue());
		System.out.println(pillow);
		
	}

}
