package Streams;

import java.util.List;
import java.util.Map;


import static java.util.stream.Collectors.*;

public class Goat {
	
	private String food;
	
	
	    
	 public Goat(String food) {
		super();
		this.food = food;
	}
	
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public static void main(String[] args) {
	       var goats = List.of(new Goat("can"), new Goat("hay"));
	       
	       Map<String, List<Goat>> collect = goats.stream().collect(groupingBy(Goat::getFood));
	       collect.entrySet().stream()
	          .filter(e -> e.getValue().size() == 2)
	          .map(e -> e.getKey())
	          .collect(partitioningBy(e -> e.isEmpty()))
	          .get(false)
	          .stream()
	          .sorted()
	          .forEach(System.out::print);

	       
//	       goats.stream()
//	          .collect(groupingBy(Goat::getFood))
//	          .entrySet()
//	          .stream()
//	          .filter(e -> e.getValue().size() == 2)
//	          .map(e -> e.getKey())
//	          .collect(partitioningBy(e -> e.isEmpty()))
//	          .get(false)
//	          .stream()
//	          .sorted()
//	          .forEach(System.out::print);
	    }

}
