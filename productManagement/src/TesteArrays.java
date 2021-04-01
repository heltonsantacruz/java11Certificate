import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TesteArrays {
	
	public static void main(String[] args) {
		
		String[] arr = {"Tea","Cake"};
		List<String> texts = Arrays.asList(arr);
		
		arr[0] = "ABC";
		for (String name: arr) {
			System.out.println(name);
		}
		System.out.println("XXXXXXXXXXXXXX");
		for (String name: texts) {
			  System.out.println(name);
		}
		
		
		texts.add("TEste");
		
		
//		TesteArrays ta = new TesteArrays();
//		String[] names = {"Mary","Jane","Elizabeth","Jo"};
//		Arrays.sort(names, new Compare());
//		for (String name: names) {
//		  System.out.println(name);
//		}
	}
	
	
	private static class Compare implements Comparator<String>{
		  public int compare(String s1, String s2) {
		    return s2.length() - s1.length();
		  }
		}
	

}
