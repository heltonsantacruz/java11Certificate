package Streams;

import java.util.stream.Stream;

public class StreamOfStreams {
	
	public static void main(String[] args) {
	     var result =
	        Stream.of(getNums(9, 8), getNums(22, 33))  // c1
	           .flatMap(x -> x)                        // c2
	           .map((a, b) -> a - b)                   // c3
	           .filter(x -> !x.isEmpty())              // c4
	           .get();      
	     System.out.println(result);
	   }
	   private static Stream<Integer> getNums(int num1, int num2) {
	      return Stream.of(num1, num2);
	   }

}
