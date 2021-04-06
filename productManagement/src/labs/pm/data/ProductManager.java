package labs.pm.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;



public class ProductManager {

	private Map<Product, List<Review>> products = new HashMap<>();
	
	//private ResourceFormatter formatter;
	
	private final ResourceBundle config = ResourceBundle.getBundle("labs.pm.data.config");
	private final MessageFormat reviewFormat = new MessageFormat(config.getString("review.data.format"));
	private final MessageFormat productFormat = new MessageFormat(config.getString("product.data.format"));
	private final Path reportsFolder = Path.of(config.getString("reports.folder"));
	private final Path dataFolder = Path.of(config.getString("data.folder"));
	private final Path tempFolder = Path.of(config.getString("temp.folder"));
	private static final Map<String, ResourceFormatter> formatters = 
			Map.of("en-GB", new ResourceFormatter(Locale.UK),
					   "en-US", new ResourceFormatter(Locale.US));
	
	private static final Logger logger = Logger.getLogger(ProductManager.class.getName());
	private static final ProductManager pm = new ProductManager();
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock writeLock = lock.writeLock();
	private final Lock readLock = lock.readLock();
	
//	public ProductManager(Locale locale) {
//		this(locale.toLanguageTag());
//	}
//	
//	
//	public ProductManager(String languageTag) {
//		changeLocale(languageTag);
//		loadData();
//		//loadAllData();
//	}
//	
	public static ProductManager getInstance() {
		return pm;
	}
	
	private ProductManager() {
		loadAllData();
	}
	
//	private void loadAllData() {
//		restoreDump();
//		loadData();
//		
//	}


	public void changeLocale(String languageTag) {
		//formatter = formatters.getOrDefault(languageTag, formatters.get("en-GB"));
	}
	
	public static Set<String> getSupportedLocales(){
		return formatters.keySet();
	}
	
	public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
		Product product = null;
		try {
			writeLock.lock();
			product = new Food(id, name, price, rating, bestBefore);
			products.putIfAbsent(product, new ArrayList<>());
		}
		catch (Exception e) {
			logger.log(Level.INFO, "Erro adding product " + e.getMessage(), e);
		}
		finally {
			writeLock.unlock();
		}
		return product;
	}
	
	
	public Product createProduct(int id, String name, BigDecimal price, Rating rating) {
		Product product = null;
		try {
			writeLock.lock();
			product = new Drink(id, name, price, rating);
			products.putIfAbsent(product, new ArrayList<>());
		}
		catch (Exception e) {
			logger.log(Level.INFO, "Erro adding product " + e.getMessage(), e);
		}
		finally {
			writeLock.unlock();
		}	
		return product;
	}
	
	public Product reviewProduct(int id, Rating rating, String comments) {
		try {
			writeLock.lock();
			return reviewProduct(findProduct(id), rating, comments);
		} catch (ProductManagerException e) {
			logger.log(Level.SEVERE, null, e);
			return null;
		}
		finally {
			writeLock.unlock();
		}
	}
	
	private Product reviewProduct(Product product, Rating rating, String comments) {
		List<Review> reviews = products.get(product);
		products.remove(product, reviews);
		reviews.add(new Review(rating, comments));
		int sum = 0;
		for(Review review : reviews) {
			sum += review.getRating().ordinal();
		}
		product = product.applyRating(Rateable.convert(Math.round((float) sum / reviews.size())));
		products.put(product, reviews);
		return product;
	}
	
	
	
	public Product findProduct(int id) throws ProductManagerException {
		try {
			readLock.lock();
			return products.keySet()
					.stream()
					.filter(p -> p.getId() == id)
					.findFirst()
					.orElseThrow(() -> new ProductManagerException("Product with id " + id + " not found"));
		}
		finally {
			readLock.unlock();
		}	
	}


	public void printProductReport(int idProduct, String languageTag, String client) {
		try {
			readLock.lock();
			printProductReport(findProduct(idProduct), languageTag, client);
		} catch (IOException  e) {
			logger.log(Level.SEVERE, "Error printing product report", e);
		} catch (ProductManagerException e) {
			logger.log(Level.INFO, e.getMessage());
		}
		finally {
			readLock.unlock();
		}
	}
	
	private void printProductReport(Product product, String languageTag, String client) throws UnsupportedEncodingException, IOException {
		ResourceFormatter formatter = formatters.getOrDefault(languageTag, formatters.get("en-US"));
		List<Review> reviews = products.get(product);
		Collections.sort(reviews);
		Path productFile = reportsFolder.resolve(MessageFormat.format(config.getString("report.file"), product.getId(), client));
		try (PrintWriter out = new PrintWriter(new OutputStreamWriter(Files.newOutputStream(productFile, StandardOpenOption.CREATE), "UTF-8"))) {
			out.append(formatter.formatProduct(product) + System.lineSeparator());
			if(reviews.isEmpty()){
				out.append(formatter.getText("no.reviews") + System.lineSeparator());
			}
			else {
				out.append(reviews.stream().map(r -> formatter.formatReview(r) + "\n").collect(Collectors.joining()));
			}
		}
	}

	
//	public void printProductReport(Product product) {
//		List<Review> reviews = products.get(product);
//		StringBuilder txt = new StringBuilder();
//		txt.append(formatter.formatProduct(product));
//		txt.append('\n');
//		Collections.sort(reviews);
//		for(Review review : reviews) {
//			txt.append(formatter.formatReview(review));
//			txt.append('\n');
//		}
//		if(reviews.isEmpty()){
//			txt.append(formatter.getText("no.reviews"));
//			txt.append('\n');
//		}
//		System.out.println(txt);
//	}
	
	
	public void printProducts(String languageTag) {
		ResourceFormatter formatter = formatters.getOrDefault(languageTag, formatters.get("en-US"));
		StringBuilder txt = new StringBuilder();
		products.keySet().stream().forEach(p -> txt.append(formatter.formatProduct(p) + "\n"));
		System.out.println(txt);
	}
	
	public void printProductsWithReviews(String languageTag) {
		ResourceFormatter formatter = formatters.getOrDefault(languageTag, formatters.get("en-US"));
		StringBuilder txt = new StringBuilder();
		products.keySet().stream().forEach(p -> txt.append("Product:" + formatter.formatProduct(p) + "\n\tReviews:\n" + products.get(p).stream().map(r -> "\t\t" + formatter.formatReview(r) + "\n").collect(Collectors.joining())));
		System.out.println(txt);
	}
	
	
	public void printProducts(Predicate<Product> filter, Comparator<Product> sorter, String languageTag) {
		try {
			readLock.lock();
			ResourceFormatter formatter = formatters.getOrDefault(languageTag, formatters.get("en-US"));
			StringBuilder txt = new StringBuilder();
			products.keySet().stream().sorted(sorter).filter(filter).forEach(p -> txt.append(formatter.formatProduct(p) + "\n"));
			System.out.println(txt);
		}
		finally {
			readLock.unlock();
		}
		
//		StringBuilder txt = new StringBuilder();
//		List<Product> productList = new ArrayList<>(products.keySet());
//		productList.sort(sorter);
//		for (Product product : productList) {
//			txt.append(formatter.formatProduct(product));
//			txt.append('\n');
//		}
	}
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void dumpData() {
		try {
			if(Files.notExists(tempFolder)) {
				Files.createDirectory(tempFolder);
			}
			String now = Instant.now().toString().replace( "-" , "" ).replace(":", "").replace(".", "").trim();
			Path tempFile = tempFolder.resolve(MessageFormat.format(config.getString("temp.file"), now));
			try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(tempFile, StandardOpenOption.CREATE))){
				out.writeObject(products);
				//products = new HashMap();
			}
		}
		catch (IOException e) {
			logger.log(Level.SEVERE, "Error dumping data" + e.getMessage(), e);
		}
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void restoreDump() {
		try {
			Path tempFile = Files.list(tempFolder)
								.filter(path -> path.getFileName().toString().endsWith("tmp"))
								.findFirst().orElseThrow(); 
			try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(tempFile, StandardOpenOption.DELETE_ON_CLOSE))){
				products = (HashMap)in.readObject();
			}
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Error retoring data" + e.getMessage(), e);
		}
	}
	
	
	private void loadAllData() {
		try {
			products = Files.list(dataFolder)
						.filter(file -> file.getFileName().toString().startsWith("product"))
						.map(file -> loadProduct(file))
						.filter(product -> product != null)
						.collect(Collectors.toMap(product -> product, product -> loadReviews(product)));
		}
		catch (IOException e) {
			logger.log(Level.SEVERE, "Error loading data" + e.getMessage(), e);
		}
		
	}
	
	
	private Product loadProduct(Path file) {
		Product product = null;
		try {
			product = parseProduct(Files.lines( dataFolder.resolve(file), Charset.forName("UTF-8"))
									.findFirst().orElseThrow());
		} catch (Exception e) {
			logger.log(Level.WARNING, "Error loading products " + e.getMessage());
		}
		return product;
				
	}
	
	private List<Review> loadReviews(Product product){
		List<Review> reviews = null;
		Path file = dataFolder.resolve(MessageFormat.format(config.getString("reviews.data.file"), product.getId()));
		if(Files.notExists(file)) {
			reviews = new ArrayList<Review>();
		}
		else {
			try {
				reviews = Files.lines(file, Charset.forName("UTF-8"))
						.map(text -> parseReview(text))
						.filter(review -> review != null)
						.collect(Collectors.toList());

			}
			catch (IOException e) {
				logger.log(Level.WARNING, "Error loading reviews " + e.getMessage());
			}
		}
		return reviews;
		
	}
	
	
	private Review parseReview(String text) {
		Review review = null;
		try {
			Object[] values = reviewFormat.parse(text);
			review = new Review(Rateable.convert(Integer.parseInt((String)values[1])), (String)values[2]);
		} catch (ParseException | NumberFormatException e ) {
			logger.log(Level.WARNING, "Error parsing review" + text, e );
		}
		return review;
	}
	
	
	private Product parseProduct(String text) {
		Product product = null;
		try {
			Object[] values = productFormat.parse(text);
			int id = Integer.parseInt((String)values[1]);
			String name = (String)values[2];
			BigDecimal price = BigDecimal.valueOf(Double.parseDouble((String)values[3]));
			Rating rating = Rateable.convert(Integer.parseInt((String)values[4]));
			switch ( (String)values[0]) {
			case "D":
				product = new Drink(id, name, price, rating);
				break;
				
			case "F":
				LocalDate bestBefore = LocalDate.parse((String)values[5]);
				product = new Food(id, name, price, rating, bestBefore);
			}
		} catch (ParseException | NumberFormatException | DateTimeParseException e ) {
			logger.log(Level.WARNING, "Error parsing product" + text, e );
		}
		return product;
	}
	
	
	
	public Map<String, String> getDiscounts(String languageTag){
		try {
			readLock.lock();
			ResourceFormatter formatter = formatters.getOrDefault(languageTag, formatters.get("en-US"));
			return products.keySet().stream().collect(
					Collectors.groupingBy(product -> product.getRating().getStars(),
							Collectors.collectingAndThen(Collectors.summingDouble(product -> product.getDiscount().doubleValue()), 
									discount -> formatter.moneyFormat.format(discount))));
		}
		finally {
			readLock.unlock();
		}
				
	}
	

	private static class ResourceFormatter{
		private Locale locale;
		private ResourceBundle resources;
		private DateTimeFormatter dateFormat;
		private NumberFormat moneyFormat;
		
		
		private ResourceFormatter(Locale locale) {
			this.locale = locale;
			resources = ResourceBundle.getBundle("labs.pm.data.resources", locale);
			dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
			moneyFormat = NumberFormat.getCurrencyInstance(locale);
		}
		
		private String formatProduct(Product product) {
			return MessageFormat.format(resources.getString("product"), 
					product.getName(),
					moneyFormat.format(product.getPrice()),
					product.getRating().getStars(),
					dateFormat.format(product.getBestBefore()));
		}
		
		private String formatReview(Review review) {
			return MessageFormat.format(resources.getString("review"), 
					review.getRating().getStars(),
					review.getComments());
		}
		
		
		private String getText(String key) {
			return resources.getString(key);
		}
	}
}
