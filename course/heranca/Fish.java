package heranca;

abstract class Fish implements MarkNoise{
	
	int $ = 8;
	
	Fish getFish() {
		throw new RuntimeException();
	}
	
	
	protected abstract int getTeste();

}
