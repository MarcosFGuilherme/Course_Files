package entities;

public class Product {
	private String Product;
	private Double price;
	
	
	public Product(String product, Double price) {
		Product = product;
		this.price = price;
	}
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [Product=" + Product + ", price=" + price + "]";
	}
}
