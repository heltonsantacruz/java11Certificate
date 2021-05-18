package Loops;

public class Loop2 {
	
	public static void main(String[] args) {
		int[] crossword [] = new int[10][20];
		
		for (int i = 0; i < crossword.length; i++)
		  for (int j = 0; j < crossword.length; j++)
		      crossword[i][j] = "x";  
		
		System.out.println(crossword.size());
	}

}
