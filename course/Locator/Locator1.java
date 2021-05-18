package Locator;

import java.util.ServiceLoader;

public class Locator1 {
	
	public static void main(String[] args) {
		ServiceLoader<Mouse> s1 = ServiceLoader.load(Locator1.class);  
		//ServiceLocator.load(Locator1.class);
	}

}
