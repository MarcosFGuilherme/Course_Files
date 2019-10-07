package entities;

public class SellItens extends Product{
	
	private int quantity;
	
	public SellItens(String product, Double price, int quantity) {
		super(product, price);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double totalItens() {
		return this.getPrice() * quantity; 
	}

	
	public String toString() {
		return "SellItens [ Product = " + this.getProduct() + " Price = " + this.getPrice() + " quantity=" + quantity + " ]";
	}
		
	public String toString(double sum) {
		return "" + this.getProduct() + "," + sum  + "";
	}
}
