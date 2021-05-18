package heranca;

public class Drum extends Instrument{
	
	
	public void play(int count) {}
	
	public void concert() {
		super.play(5);
	}
	
	public static void main(String[] args) {
		Drum d = new Drum();
	}

}
