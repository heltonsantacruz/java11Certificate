import java.util.Arrays;
import java.util.Comparator;

public class TesteArrays {
	
	public static void main(String[] args) {
		TesteArrays ta = new TesteArrays();
		String[] names = {"Mary","Jane","Elizabeth","Jo"};
		Arrays.sort(names, new Compare());
		for (String name: names) {
		  System.out.println(name);
		}
	}
	
	
	private static class Compare implements Comparator<String>{
		  public int compare(String s1, String s2) {
		    return s2.length() - s1.length();
		  }
		}
	

}
