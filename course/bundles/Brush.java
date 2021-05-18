package bundles;

import java.util.Locale;
import java.util.ResourceBundle;

public class Brush {
	
	public static void main(String[] args) {
//		 Locale.setDefault(new Locale.Builder().setLanguage("es").setRegion("MX").build());
//		 var rb = ResourceBundle.getBundle("bundles\\toothbrush", new Locale("fr"));
//		 //var rb = ResourceBundle.getBundle("bundles\\toothbrush");
//		 var a = rb.getString("color");
//		 var b = rb.getString("type");
//		 System.out.print(a +  " " + b);
		 
		 
//		 Locale.setDefault(new Locale("en", "US"));
//		 var rb2 = ResourceBundle.getBundle("bundles\\toothbrush", new Locale("fr"));
//		 System.out.print(rb2.getString("green"));
		 
		 
		 Locale.setDefault(new Locale("en", "US"));
		 var rb = ResourceBundle.getBundle("bundles\\toothbrush", new Locale("ca","ES"));
		 System.out.print(rb.getString("red"));



	}

}
