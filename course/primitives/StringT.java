package primitives;

public class StringT {
	
	public static void main(String[] args) {
		String teste = new String("iwoufoiu  i uoiuiou o po iopi op i  i u  ");
		var var = teste.lines();
		var.forEach(System.out::println);
		System.out.println(var);
		String g = "G";
		System.out.println(g.repeat(5));
	}

}
