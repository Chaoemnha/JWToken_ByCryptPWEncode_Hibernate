package jmaster.io.restapi.model;

public class CartItem {
	private Product product;
	//private User user;
	private int quantity;
	
	public CartItem(Product product, int quantity) {
		super();
		this.product = product;
		//this.user.setUsername(user);
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return quantity*product.getPrice();
	}
}
