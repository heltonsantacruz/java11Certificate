package Arrays;

public class Dimensional {
	
	public static void main(String[] args) {
		int[] crossword [] = new int[10][20];
		 for (int i = 0; i < crossword.length; i++)
		    for (int j = 0; j < crossword.length; j++)
		       crossword[i][j] = 'x';  
		 System.out.println(crossword.length); 
//  	System.out.println(crossword[i][j]);	
		 System.out.println(crossword.length);
		 for (int i = 0; i < crossword.length; i++) {
			 System.out.println("IMprimindo crossword"+i);
			 for (int j = 0; j < crossword[i].length; j++) {
				 System.out.print(crossword[i][j]+ ",");
			 }
			 System.out.println();
		 }

//		 for (int j = 0; j < crossword.length; j++)
//		 System.out.println(crossword);
	}

}
