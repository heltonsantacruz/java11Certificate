package Streams;

import java.util.stream.IntStream;

public class Boxed {
	
	
	public static void main(String[] args) {
		double sum = IntStream.of(4, 6, 8)
				    .boxed()
				    //.parallel()
				    .mapToInt(x -> x)
				    .sum();
		 System.out.print(sum);
	}

}
