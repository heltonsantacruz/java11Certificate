package Generics;

import java.util.ArrayList;
import java.util.List;

public class FormasCriacao {
	
	
	
	
	Roller<CartWheel> wheel1 = new Roller<CartWheel>();
	   Roller<Wheel> wheel2 = new Roller<CartWheel>();
	   Roller<? extends Wheel> wheel3 = new Roller<CartWheel>();
	   Roller<? extends Wheel> wheel4 = new Roller<Wheel>();
	   Roller<? super Wheel> wheel5 = new Roller<CartWheel>();
	   Roller<? super Wheel> wheel6 = new Roller<Wheel>();
	   
	   List<?> n = new ArrayList<>();
	   List<? extends RuntimeException> o = new ArrayList<Exception>();
	   List<? super RuntimeException> p = new ArrayList<Exception>();
	   List<T> q = new ArrayList<?>();
	   List<T extends RuntimeException> r = new ArrayList<Exception>();
	   List<T super RuntimeException> s = new ArrayList<Exception>();


}
