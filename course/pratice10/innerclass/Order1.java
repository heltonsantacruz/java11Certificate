package pratice10.innerclass;

public class Order1 {
	
	public static int test = 0;
	
	public static void createShippingMode(String description) {		
		new ShippingMode(description);
	}
	
	
	private static class ShippingMode{
		private String description;
		
		public ShippingMode(String description) {
			this.description = description;
			test++;
		}
	}
	
	
	public static void main(String[] args) {
		Order1.createShippingMode("Fast");
		
		Order1 order1 = new Order1();
		System.out.println(order1.test);
	}

}
