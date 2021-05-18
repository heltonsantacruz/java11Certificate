package heranca;

import java.util.List;

public @interface Living {
	
	
//	public default String grow() { return "Grow!"; }
	int getT();
	String g() default null;
	//List getList(); 
	
	//int[] value() default 100;

	//abstract int $rr();
	//int max() default 1;
	//Integer maxTemp() default 1;
	//public default String grow() { return "Super Growing!"; }
	//int getT();
}
