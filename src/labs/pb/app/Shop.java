package labs.pb.app;

import java.math.BigDecimal;
import java.util.Comparator;

import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

public class Shop {
	
	public static void main(String[] args) {
		ProductManager pm = new ProductManager("en-US");
		
		Product product1 = pm.createProduct(101,"Tea", BigDecimal.valueOf(2.99), Rating.NOT_RATED);
		//pm.printProductReport(p1);
		
		pm.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of tea");
		pm.reviewProduct(101, Rating.TWO_STAR, "Rather weak tea");
		pm.reviewProduct(101, Rating.FOUR_STAR, "Fine Tea");
		pm.reviewProduct(101, Rating.FOUR_STAR, "Good Tea");
		pm.reviewProduct(101, Rating.FIVE_STAR, "Perfect tea");
		pm.reviewProduct(101, Rating.THREE_STAR, "Just add some lemon");
		//pm.printProductReport(p1);
		
		
		
		Product product2 = pm.createProduct(102,"Coffe", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
		//pm.printProductReport(p2);
		
		pm.reviewProduct(102, Rating.TWO_STAR, "Rather weak coffe");
		//pm.reviewProduct(102, Rating.FOUR_STAR, "Fine coffe");
		//pm.reviewProduct(102, Rating.FOUR_STAR, "Good Coffe");
		//pm.reviewProduct(102, Rating.FIVE_STAR, "Perfect Coffe");
		//pm.printProductReport(product2);
		
		pm.printProducts((p2,p1) -> p2.getRating().ordinal() - p1.getRating().ordinal() );
		pm.printProducts((p2,p1) -> p2.getPrice().compareTo(p2.getPrice()));
		
		Comparator<Product> ratingSorter = (p1,p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
		Comparator<Product> priceSorter = (p1,p2) -> p2.getPrice().compareTo(p1.getPrice());
		pm.printProducts(ratingSorter.thenComparing(priceSorter));
		
		pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());
		
		
	}

}
