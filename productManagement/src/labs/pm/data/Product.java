package labs.pm.data;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;;

public abstract class Product implements Rateable<Product>{
	
	
	public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
	private int id;
	private String name;
	private BigDecimal price;
	private Rating rating;
	
//	
//	public Product() {
//		
//	}
	
	
	public Product(int id, String name, BigDecimal price, Rating rating) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
	}
	
	public Product(int id, String name, BigDecimal price) {
		this(id,name,price,Rating.NOT_RATED);
	}
	
	
	public LocalDate getBestBefore() {
		return LocalDate.now();
	}
	
	@Override
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
//	public void setPrice(BigDecimal price) {
//		this.price = price;
//	}
	
	public BigDecimal getDiscount() {
		return price.multiply(DISCOUNT_RATE).setScale(2,HALF_UP);
	}
	
//	public abstract Product applyRating(Rating newRating); 
//	{
//		return new Product(this.id, this.name, this.price, newRating);
//	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", rating=" + rating + "]";
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 23 * hash + this.id;
		return hash;
//		
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((price == null) ? 0 : price.hashCode());
//		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
//		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
//		if (obj != null && getClass() == obj.getClass()) {
		if (obj instanceof Product) {
			final Product other = (Product) obj;
			return this.id == other.id && Objects.equals(this.name, other.name);
		}
		return false;
	}
	
	
	
	
	

}
