package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Criation {
	
	
	
	private void create() {
			List<?> n = new ArrayList<>();
			List<? extends RuntimeException> o = new ArrayList<Exception>();
			List<? super RuntimeException> p  = new ArrayList<Exception>();
			List<T> q = new ArrayList<?>();
			List<T extends RuntimeException> r = new ArrayList<Exception>();
			List<T super RuntimeException> s = new ArrayList<Exception>();
	}
	
	public static void main(String[] args) {
		int[] zeta = new int[3];
		var t = zeta;

		
		
		
		String lions = new String[3];
		String[] tigers = new String[1] {"tiger"};
		String bears[] = new String[] {"dfdf", "sdfsdfsdf"};
		String bears2[] = {"dfdf", "sdfsdfsdf"};
		String bears3[] = new String[] {};
		String ohMy [] = new String[0] {};
		
		for (int i = 0; i < bears.length; i++) {
			System.out.println(bears[i]);
			
		}
	}
	
	
	
	//warning
//	List<String> a = new ArrayList<String>();
//	List<> b = new ArrayList<String>();
//	List<String> c = new ArrayList();
//	List<String> d = new ArrayList<>();
//	List<> e = new ArrayList<String>();
//	List<> f = new ArrayList<>();
//	List<> g = new ArrayList();
	

}
