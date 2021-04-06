package labs.pb.app;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.ProductManagerException;
import labs.pm.data.Rating;

public class Shop {
	
	public static void main(String[] args) throws ProductManagerException, UnsupportedEncodingException, IOException {
		
		ProductManager pm = ProductManager.getInstance();
		
		
		AtomicInteger clientCount = new AtomicInteger(0);
		Callable<String> client = () -> {
			String clientId = "Client " + clientCount.incrementAndGet();
			String threadName = Thread.currentThread().getName();
			int productId = ThreadLocalRandom.current().nextInt(14)+10;
			String languageTag = ProductManager.getSupportedLocales()
								.stream()
								.skip(ThreadLocalRandom.current().nextInt(2))
								.findFirst().get();
			StringBuilder log = new StringBuilder();
			log.append(clientId + " " + threadName+"\n-\tstart of log\t-\n");
			log.append(pm.getDiscounts(languageTag)
					.entrySet()
					.stream()
					.map(entry -> entry.getKey() + "\t" + entry.getValue())
					.collect(Collectors.joining("\n")));
			Product product = pm.reviewProduct(productId, Rating.FOUR_STAR, "Yet another review");
			log.append((product != null) ? "\nProduct " + productId + " reviewed\n" : "\nProduct " + productId + " not reviewed\n");
			pm.printProductReport(productId, languageTag, clientId);
			
			log.append(clientId+ " generated report for " + productId + " product");
			log.append("\n-\tend of log\t-\n");
			
			return log.toString();
		};
		
		List<Callable<String>> clients = Stream.generate( () -> client).limit(5).collect(Collectors.toList());
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		try {
			List<Future<String>> results = executorService.invokeAll(clients);
			executorService.shutdown();
			results.parallelStream().forEach(result -> {
				try {
					System.out.println(result.get());
				}
				catch (InterruptedException |  ExecutionException e) {
					Logger.getLogger(Shop.class.getName()).log(Level.SEVERE,null,e);
				}
			});
		}
		catch (InterruptedException e) {
			Logger.getLogger(Shop.class.getName()).log(Level.SEVERE,null,e);
		}
		
		//ProductManager pm = new ProductManager("en-US");
		
		//pm.dumpData();
		//pm.restoreDump();
		//pm.printProducts("en-US");
		//pm.printProductsWithReviews("en-US");
		
		
		
		
		
		
//		Map discounts = pm.getDiscounts(null);
//		Product product1 = pm.createProduct(101,"Tea", BigDecimal.valueOf(2.99), Rating.NOT_RATED);
//		pm.reviewProduct(101, Rating.TWO_STAR, "Rather weak coffe");
//		pm.reviewProduct(101, Rating.FOUR_STAR, "Fine coffe");
//		pm.reviewProduct(101, Rating.FOUR_STAR, "Good Coffe");
//		pm.reviewProduct(101, Rating.FIVE_STAR, "Perfect Coffe");
//		
//		
//		pm.printProductReport(product1);
		
		
		//pm.parseProduct("D,204,Tea,1.99,0,2019-09-19");
		//pm.parseReview("204,4,Nice hot cup of tea");
		//pm.printProductReport(204);
		
		
		
//		pm.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of tea");
//		pm.reviewProduct(101, Rating.TWO_STAR, "Rather weak tea");
//		pm.reviewProduct(101, Rating.FOUR_STAR, "Fine Tea");
//		pm.reviewProduct(101, Rating.FOUR_STAR, "Good Tea");
//		pm.reviewProduct(101, Rating.FIVE_STAR, "Perfect tea");
//		pm.reviewProduct(101, Rating.THREE_STAR, "Just add some lemon");
//		pm.printProductReport(pm.findProduct(101));
//		
		
		
		//Product product2 = pm.createProduct(102,"Coffe", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
		//pm.printProductReport(p2);
		
		//pm.reviewProduct(102, Rating.TWO_STAR, "Rather weak coffe");
		//pm.reviewProduct(102, Rating.FOUR_STAR, "Fine coffe");
		//pm.reviewProduct(102, Rating.FOUR_STAR, "Good Coffe");
		//pm.reviewProduct(102, Rating.FIVE_STAR, "Perfect Coffe");
		//pm.printProductReport(product2);
		
		//pm.printProducts((p2,p1) -> p2.getRating().ordinal() - p1.getRating().ordinal() );
		//pm.printProducts((p2,p1) -> p2.getPrice().compareTo(p1.getPrice()));
		
		//Comparator<Product> ratingSorter = (p1,p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
		//Comparator<Product> priceSorter = (p1,p2) -> p2.getPrice().compareTo(p1.getPrice());
		//pm.printProducts(ratingSorter.thenComparing(priceSorter));
		
		//pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());
		
		
		
		System.out.println("Fim");
		
		
		
		
	}

}
