package Monitor;

public class Monitor {
	
	public static void main(String[] args) {
		var result = 8;
		monitor: while (result>= 7) {
			result++;
			do {
				result -= 2;
				continue monitor;
			} while (result> 5);
		}
		System.out.println(result);
	}

}
