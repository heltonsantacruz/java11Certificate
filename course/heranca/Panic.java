package heranca;

public @interface Panic {
	
	public abstract int alert() default 10;
	public final static int alarm_volume = 10;
	String[] type() default {"test"};
	Long range();
	abstract boolean silent();

}
