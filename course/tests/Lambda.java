package tests;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {
	
	
	public static void main(String[] args) {
		String names = Stream.of("bald eagle", "pronghorn", "puma", "sea lion")
				.collect(Collectors.toUnmodifiableSet())
	/*F*/		.stream()
				.collect(Collectors.groupingBy(s -> s.contains(" ")))
				.entrySet()
				.stream()
				.filter(e -> e.getKey())
				.map(Entry::getValue)
				.flatMap(List::stream)
				.sorted(Comparator.reverseOrder())
				
			   .collect(Collectors.joining("," ));
				System.out.println(names);
	}
	
//	B
//	.filter(s -> s.contains(" "))
//	.collect(Collectors.toUnmodifiableSet())
//	.stream()
//	.entrySet()
//	.stream()
//	.filter(e -> e.getKey())
//	.map(Entry::getValue)
//	.flatMap(List::stream)
//	.sorted(Comparator.reverseOrder())
	
//	A
//	.filter(s -> s.contains(" "))
//	.collect(Collectors.toSet())
//	.stream()
//	.entrySet()
//	.stream()
//	.filter(e -> e.getKey())
//	.map(Entry::getValue)
//	.flatMap(List::stream)
//	.sorted(Comparator.reverseOrder())
	
	
//	E
//	.filter(s -> s.contains(" "))
//	.collect(Collectors.toUnmodifiableSet())
//	.stream()
//	.collect(Collectors.groupingBy(s -> s.contains(" ")))
//	.entrySet()
//	.stream()
//	.filter(e -> e.getKey())
//	.map(Entry::getValue)
//	.map(List::stream)
//	.sorted(Comparator.reverseOrder())
	
	
//	C
//	.collect(Collectors.toUnmodifiableSet())
//	.stream()
//	.collect(Collectors.groupingBy(s -> s.contains(" ")))
//	.entrySet()
//	.stream()
//	.filter(e -> e.getKey())
//	.map(Entry::getValue)
//	.map(List::stream)
//	.sorted(Comparator.reverseOrder())

}
