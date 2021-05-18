package Paths;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Normalize {
	
	
	public static void main(String[] args) {
		
		String h;
		Integer r = 45;
		
		switch (r) {
		case 86:
			System.out.println(h);
			break;

		default:
			break;
		}
		
		
		Path x = Paths.get(".","\\song","..","\\note");
//		Path r = Paths.get("\\song\\note");
		Path y = Paths.get("\\dance\\move.txt");
//		System.out.println(x);
		Path z = x.normalize();
		System.out.println(z);
//		System.out.println(x.resolve(y));
//		System.out.println(y.resolve(x));
//		System.out.println(y.resolve(z));
//		System.out.println(y.resolve(r));
	}

}
