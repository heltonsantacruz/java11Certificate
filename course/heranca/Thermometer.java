package heranca;

public @interface Thermometer {
	int minTemp();
	Integer maxTemp() default 1;
	double[] color();
	final String type;
	Boolean compact;

}
