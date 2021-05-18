package Properties;

import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;



public class PropertiesTest {
	
	
	public static void main(String[] args) {
		
		Map<String, String> map = new TreeMap<>();
		map.put("tool", "hammer");
		
		 
		var props = new Properties();
		map.forEach((k,v) -> props.put(k, v));  // p2
		 
		StringT t = props.getProperty("tool");   // p3
		
		
		var race = "";
		loop234545:
		//do {
		    race += "x";
		    //break loop;
		 //} while (true);
		 System.out.println(race);
		 
		 
		 loop234546:
		 int r = 9;	 
		
	}

}
