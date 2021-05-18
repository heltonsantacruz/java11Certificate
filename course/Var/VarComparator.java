package Var;

import java.util.Comparator;

public class VarComparator {
	
	public static void main(String[] args) {

				 Comparator<String> c1 = (j, k) -> 0;
				 Comparator<String> c2 = (String j, String k) -> 0;
				 Comparator<String> c3 = (var j, String k) -> 0;
				 Comparator<String> c4 = (var j, k) -> 0;
				 Comparator<String> c5 = (var j, var k) -> 0;
	}

}
