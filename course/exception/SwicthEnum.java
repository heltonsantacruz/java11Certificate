package exception;

import Enum.Enum2;

public class SwicthEnum {

	public static void main(String[] args) {
		
		 final Enum2 input = Enum2.A;
	      switch(input) {
	         default:
	        	 
	         case A:
	            System.out.print("1");
	         case Enum2.B:
	            System.out.print("2");
	      }
		
	}
}
