package tests;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Map {
	
	public static void main(String[] args) {
		var m = new TreeMap<Integer, Integer>();
		m.put(1, 4);
		m.put(2, 8);
		
		System.out.println("1");
		System.out.println(m);
		
		System.out.println("2");
		m.putIfAbsent(2, 10);
		m.putIfAbsent(3, 9);
		System.out.println(m);
		
		System.out.println("3");
		m.replaceAll((k, v) -> k + 1);
		System.out.println(m);
		 
		m.entrySet().stream()
		    .sorted(Comparator.comparing(Entry::getKey))
		    .limit(1)
		    .map(Entry::getValue)
		    .forEach(System.out::println);
	}

}
