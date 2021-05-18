package heranca;

public class Dinosaur {
	
	 class Pterodactyl extends Dinosaur {
		 
	 }
	   
	 public void roar() {
	      var dino = new Dinosaur().new Pterodactyl();
	      //var dino2 = Dinosaur.new Pterodactyl();
	      var dino2 = new Dinosaur();
	      dino2.new Pterodactyl();
	      new Dinosaur.Pterodactyl();
	      new Dinosaur().new Pterodactyl();
	   }
	 
	 
	 public static void main(String[] args) {
		 var dino = new Dinosaur();
	      dino.new Pterodactyl();
	      new Dinosaur().new Pterodactyl();
	      new Dinosaur().new Pterodactyl();
	}

}
