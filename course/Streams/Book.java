package Streams;

import java.util.stream.IntStream;

public class Book {
	
	
	   public static void main(String[] args) {
	       IntStream pages = IntStream.of(200, 300);
	       long total = pages.sum();
	       long count = pages.count();
	       //System.out.println(total + '-' + count);
	       System.out.println(total);
	       System.out.println(count);
	    }

}
