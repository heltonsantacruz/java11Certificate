package Operators;

import java.util.Scanner;

public class Operator {
	
	public static void main(String[] args) {
		
//		System.out.print("Enter something:");
//		String input = System.console().readLine();
//		
		System.out.println("Enter something:");
		Scanner in = new Scanner(System.in);

		int i = in.nextInt();
		String s = in.next();
		System.out.println(s);
		
		//System.out.println(input);
//		var gas = true;
//		do {
//		   System.out.println("helium");
//		   gas = gas ^ gas;
//		   //System.out.println(gas);
//		   gas = !gas;
//		} while (!gas);
//		//System.out.println(gas);
	}

}
